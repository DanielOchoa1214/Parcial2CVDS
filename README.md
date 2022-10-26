## Daniel Sebastian Ochoa Urrego

### CVDS – Ciclos de Vida Desarrollo de Software
### Parcial Segundo Tercio

Lo primero que se hizo fue clonar el proyecto a la maquina local con el comando

    git clone https://github.com/isanchezf/2022-2-par2t.git master

Y se creo un repositorio remoto en mi cuenta personal de GitHub y subimos el parcial

![](./img/RepositoryCreation.png)
![](./img/RepositoryFirstScreen.png)

### Primer punto

Antes de empezar a describir como se realizo este punto debo confesar que no hice la implementación de los métodos
exactamente descritos en el enunciado, pues este fue el ultimo punto del parcial que hice, (Pues queréa hacer los otros para
intentar conocer bien el proyecto antes de intentar realizar pruebas) y al hacerlo no me di cuenta que los métodos de los
siguientes puntos ya estaban especificados en la interfaz de ServiciosPaciente por lo que hice mis propios métodos, que a 
la final son lo mismo que los que ya estaban pero con otros nombres, y me di cuenta al realizar este punto pero ya terminando 
el parcial tendría que cambiar todo lo que he hecho hasta ahora y no creo que es la mejor opción

La prueba implementada fue la siguiente

![](./img/ImplementacionPrueba.png)

En donde primero hacemos todo el Arrange conectándonos a la base de datos y creando los objetos apropiados
para realizar las comprobaciones con los objetos creados a partir de la base de datos volatil

Luego en el Act simplemente se llama al método getPacientesById de la clase ServiciosPaciente para
hacer el llamado a la base de datos

Y por ultimo el Assert en donde comprobamos que los objetos creados sean iguales, por lo que tambien se tubo que sobreescribir
el método equals en las clases Paciente y Consulta para definir las igualdades

![](./img/PacienteEquals.png)
![](./img/ConsultaEquals.png)

### Segundo punto

Lo primero que hay que hacer para que este punto se pueda hacer es cambiar el archivo de config.properties y poner las credenciales correctas para poder realizar la coneccion con el servidor, se debe cambar la contraseña de autenticacion por "prueba2019"

![](./img/configFile.png)

Luego de esto se empieza implementando la consulta en SQL en el archivo "PacienteMapper.xml"

![](./img/xmlSQLSentence.png)

Y ya que las consultas del paciente son un atributo de lista, este se mapeo se debe especificar en otro resultMap

![](./img/ConsultaSQL.png)

Y ahora creamos la función getPacientesById en el PacienteMapper de Java para poder usarlo en el los DAO

![](./img/PacienteMapperJava.png)

Luego tanto en la interfaz DAO como en su implementación se le agrega un metodo load que llame al metodo getPacienteById en el PacienteMapper

![](./img/DAOPacienteById.png)
![](./img/DAOPacienteIdImpl.png)

Luego tanto en la interfaz del servicio como en la implementación de esta añadimos un metodo getPacienteById en el que se llama al metodo load creado anteriormente

![](./img/ServicioPacienteById.png)
![](./img/ServicioPacienteByIdImpl.png)

Luego en el bean solo le añadimos un atributo de paciente y una función loadPacienteById ya que ya se tenia implementado el tipo de identificación en el proyecto entregado en el enunciado

![](./img/PacienteByIdBean.png)

Y por ultimo debemos crear la pagina en xhtml en el archivo "consultaPaciente.xhtml" haciendo todos los respectivos bindings entre los componentes de la pagina y los atributos de donde se sacaran los
datos en el Bean, ademas de conectar la función loadPaciente del Bean con el click del botón de "Consultar"

![](./img/ConsultaPacientesXHTML.png)

Y para verificar que el servicio funciona iniciamos el servicio tomcat, entramos a la pagina y buscamos una ID que este en la base de datos

![](./img/Punto2Funcionando.png)

### Tercer punto

Para este punto seguimos el mismo proceso, primero definimos la consulta SQL en el archivo PacienteMapper.xml, pero esta vez no debemos hacer otro resultMapper ya que con el creado anteriormente funcionaria bien

![](./img/ConsultaEnfermos.png)

Y luego agregamos el método en la interfaz PacienteMapper de Java

![](./img/ContagiososPacienteMapper.png)

Y agregamos un método loadContagiosos en la interfaz DAO y su implementación que llame el método del mapper

![](./img/DAOContagiosos.png)
![](./img/DAOBatisContagiosos.png)

Luego agregamos un método getContagiousMenores tanto en la implementación del servicio como en su interfaz que llame al método load creado anteriormente

![](./img/ServicioIntefazContagiosa.png)
![](./img/ServicioImplContagiosa.png)

Y por ultimo creamos un nuevo atributo en el Bean para los menores contagiosos, junto con su getter y un método load que cargue los valores de la base de datos al atributo llamando el método del servicio

![](./img/BeanContagiosos.png)

Y ya con todo en Java terminado podemos empezar a crear el diseño de la pagina web en el archivo "consultarMenoresEnfermedadContagiosa.xhtml" bindiando los valores del Bean a los componentes de la pagina

![](./img/XHTMLContagioso.png)

Y verificamos que funcione iniciando el servidor, entrando a la pagina y dandole al botón consultar

![](./img/WebContagiosa.png)

Y podemos verificar que la información es correcta viendo todos los pacientes de ta tabla PACIENTES con el método consultarPacientes implementado en el main del proyecto

![](./img/MainJava.png)
![](./img/MainResult.png)
