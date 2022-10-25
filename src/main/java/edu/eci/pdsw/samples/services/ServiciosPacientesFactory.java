/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import org.apache.log4j.BasicConfigurator;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOPaciente;
import edu.eci.pdsw.samples.services.impl.ServiciosPacienteImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacientesFactory {

    private static ServiciosPacientesFactory instance = new ServiciosPacientesFactory();

    private static Injector injector;
    private static Injector testingInjector;

    private ServiciosPacientesFactory() {
        injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosPaciente.class).to(ServiciosPacienteImpl.class);
                bind(DaoPaciente.class).to(MyBatisDAOPaciente.class);

            }

        }
        );

        testingInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServiciosPaciente.class).to(ServiciosPacienteImpl.class);
                bind(DaoPaciente.class).to(MyBatisDAOPaciente.class);
            }

        }
        );

    }

    public ServiciosPaciente getForumsServices() {
        return injector.getInstance(ServiciosPaciente.class);
    }

    public ServiciosPaciente getTestingForumServices() {
        return testingInjector.getInstance(ServiciosPaciente.class);
    }

    public static ServiciosPacientesFactory getInstance() {
        return instance;
    }

    public static void main(String[] a) throws ExcepcionServiciosSuscripciones, SQLException {
        System.out.println(ServiciosPacientesFactory.getInstance().getForumsServices().consultarPacientes());
    }

}
