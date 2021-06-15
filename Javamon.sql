
  --Base de datos para el proyecto de subida de nota de Santiago Martínez Aral

  CREATE DATABASE Javamon
  GO

  USE Javamon
  GO

  GO
  --Tabla Entrenador
  CREATE TABLE Entrenador (
	
	codigoEntrenador smallint not null Constraint PKEntrenador Primary Key
	, nombre nvarchar(15) not null
	, dinero float null
	, frase nvarchar(150) null
	, aprobados int null
	, CONSTRAINT CK_aprobados CHECK (aprobados BETWEEN 0 AND 4) --Solo puedes tener hasta 4 aprobados que sería el fin del juego

  )

  GO
   --Tabla Javamon
  CREATE TABLE Javamon (
	
	codigoJavamon smallint not null Constraint PKJavamon Primary Key
	, nombre nvarchar(15) not null
	, tipo nvarchar(15) not null
	, descripcion nvarchar(374) null
	, nivel smallint not null 
	, salud int not null
	, danho int not null
	, velocidad int not null
	, starter bit null -- El tipo de dato bit lo uso para simular un booleano, si es 0 será false y si es 1 true
	, codigoEntrenador smallint null Constraint FKEntrenador Foreign Key References Entrenador (codigoEntrenador) On Update No action On Delete No action
	, CONSTRAINT CK_numeroNivel CHECK (nivel BETWEEN 1 AND 10)
	, CONSTRAINT CK_salud CHECK (salud >= 0)
	, CONSTRAINT CK_danho CHECK (danho >= 0)
	, CONSTRAINT CK_velocidad CHECK (velocidad >= 0)
	, CONSTRAINT CK_tipo CHECK (tipo IN ('analista', 'programador', 'tester', 'Leo'))
  )

  GO
   --Tabla Ataque
  CREATE TABLE Ataque (
	
	nombre nvarchar(50) not null Constraint PKAtaque Primary Key
	, descripcion nvarchar(127) not null
	, stat nvarchar(15) null
	, cantidad int null
	, CONSTRAINT CK_stat CHECK (stat IN ('salud', 'danho', 'velocidad'))
	, CONSTRAINT CK_cantidad CHECK (cantidad >= 0)

  )

  GO
   --Tabla Combate
  CREATE TABLE Combate (
	
	idCombate smallint not null Constraint PKCombate Primary Key
	, vencedor bit null -- El tipo de dato bit lo uso para simular un booleano, si es 0 será false y si es 1 true
	, codigoEntrenador1 smallint not null 
	, codigoEntrenador2 smallint null 
	, Constraint FKEntrenador1 Foreign Key (codigoEntrenador1) References Entrenador (codigoEntrenador) On Update No action On Delete No action
	, Constraint FKEntrenador2 Foreign Key (codigoEntrenador2) References Entrenador  (codigoEntrenador) On Update No action On Delete No action
	
  )

  GO
     --Tabla JavamonAtaque
  CREATE TABLE JavamonAtaque (
	
	codigoJavamon smallint not null
	, nombre nvarchar(50) not null 
	, Constraint PKJavamonAtaque Primary Key (codigoJavamon, nombre)
	, Constraint FKJavamon Foreign Key (codigoJavamon) References Javamon (codigoJavamon) On Update No action On Delete No action
	, Constraint FKAtaque Foreign Key (nombre) References Ataque (nombre) On Update No action On Delete No action	
	
  )

  GO
       --Tabla CombateJavamon
  CREATE TABLE CombateJavamon (
	
	 idCombate smallint not null
	, codigoJavamon smallint not null
	, Constraint PKCombateJavamon Primary Key (idCombate, codigoJavamon)
	, Constraint FKJavamonCombate Foreign Key (codigoJavamon) References Javamon (codigoJavamon) On Update No action On Delete No action
	, Constraint FKCombate Foreign Key (idCombate) References Combate (idCombate) On Update No action On Delete No action	
	
  )

  
  -- Inserto los datos iniciales del programa
  --Los Entrenadores
	INSERT INTO [dbo].[Entrenador]
            ([codigoEntrenador], [nombre], [dinero], [frase], [aprobados])

     VALUES (1, 'Beatriz', null, 'Los 4,9 son 4 para mí, así que te será complicado conseguir el apobado', null)
		  , (2, 'Raúl', null, 'Aquí no hay porcentajes que te salven, o me ganas al 100 % o te quedas sin tu aprobado', null)
		  , (3, 'Miguel Ángel', null, '... ... Buena suerte ... ...', null)
		  , (4, 'Fernando', null, 'Te espero en segundo', null)
		
  --Los javamons
  INSERT INTO [dbo].[Javamon] -- todos los javamons
          ([codigoJavamon],[nombre], [tipo], [descripcion], [nivel], [salud], [danho], [velocidad], [starter], [codigoEntrenador])

   VALUES (1, 'Duml', 'analista','Fue creado por el analista Booch, de ahí su tipo, tras un fallo en el desarrollo de un diagrama de clase. Este javamon es muy observador, le gusta tenerlo todo bajo control y no saltarse ningún detalle.', 1, 100, 17, 7, 1, null)
		, (2, 'Intellimon', 'programador','Se encarga de ayudar con los programas de la región, mantiene la cohesión y evita las excepciones entre los javamons, para muchos es el más fuerte.', 1, 70, 20, 15, 1, null)
		, (3, 'Junitson', 'tester', 'Un javamon al que no le gusta llamar la atención, espera sin hacer ruido pero es capaz de detectar cualquier fallo en sus oponentes. Se lleva especialmente mal con los de tipo programador.', 1, 80, 20, 10, 1, null)
		, (4, 'Omabyte', 'tester', 'Un javamon muy antiguo, de los primeros que se descubrieron. Suelen atacar en grupos de 8.', 1, 60, 20, 12, 0, null)
		, (5, 'Virtualrex', 'tester', 'Era el rey de los javamons originales gracias a su habilidad de crear ilusiones de mundos similares al real en el que entrenar su fuerza. Se dice que su primer entrenador fue Jose María hace millones de años.', 1, 75, 25, 7, 0, null)
		, (6, 'Pingux', 'tester', 'Un javamon muy pacífico que se encarga de ayudar al resto a mejorar y crecer. Pese a su frágil y amable apariencia, esconde un gran poder en su interior.', 1, 90, 15, 5, 0, null)
		, (7, 'Metabug', 'tester', 'Un javamon muy singular pero con una característica muy especial, puede solucionar cualquier error . Suele ser el javamon de la policía nacional de Nervionia.', 1, 100, 10, 8, 0, null)
		, (8, 'Tracerbro', 'tester', 'Es capaz de conectar cualquier red, y su amabilidad permite que este sea de gran ayuda para la región.', 1, 70, 20, 7, 0, null)
		, (9, 'Netcreans', 'programador','Es similar a Intellimon pero menos poderoso. Tiene un aspecto más viejo y dejado.', 1, 65, 15, 12, 0, null)
		, (10, 'MrPedro', 'programador','Un javamon muy peculiar con apariencia de payaso. Es gracioso y sociable, pero no tiene fuerza alguna. Resulta inútil en el combate.', 1, 50, 0, 20, 0, null)
		, (11, 'Nidoget', 'programador','Es un javamon que muestra mucho sus sentimientos. Junto con su hermano Nidoset hacen una dupla increíble.', 1, 75, 20, 10, 0, null)
		, (12, 'Nidoset', 'programador','Es un javamon que cambia mucho de personalidad. Junto con su hermano Nidoget hacen una dupla increíble.', 1, 60, 25, 13, 0, null)
		, (13, 'Paraface', 'programador','Es un javamon muy mandón. Obliga a sus adversarios y entorno a seguir sus pautas.', 1, 70, 20, 9, 0, null)
		, (14, 'Policatch', 'programador','Cree que es un superhéroe y va por la región capturando las excepciones del mal.', 1, 80, 15, 7, 0, null)
		, (15, 'Actor', 'analista','Se encarga de permitir las relaciones en la región. Son el mejor compañero de todo político.', 1, 100, 10, 15, 0, null)
		, (16, 'Tentafol', 'analista','Un javamon muy preventivo, es capaz de ver las catástrofes antes de que sucedan y poder evitarlas. Velan por la seguridad de todos.', 1, 80, 20, 9, 0, null)
		, (17, 'Herencius', 'analista','Es muy misterioso y sombrío. Usa técnicas prohibidas como la herencia múltiple. Suele aparecer en las pesadillas de la gente.', 1, 90, 25, 10, 0, null)
		, (18, 'Loopholmes', 'analista','Le gusta hacer de  detective y seguir cada pista que ve. Puede llegar a hacer lo mismo  en repetidas ocasiones.', 1, 65, 25, 15, 0, null)
		, (19, 'Starcase', 'analista','El javamon filósofo. Se dedica a pensar y analizar el entorno. No es el más fuerte, pero sí el más sabio.', 1, 100, 10, 5, 0, null)
		, (20, 'Leo', 'Leo','El legendario de la región, el javamon más fuerte. Nadie ha podido controlarlo, aunque muchos lo hayan visto. Se dice que es capaz de fulminar uan civilización entera con su ataque', 1, 150, 80, 10, 0, null)
		, (21, 'Duml', 'analista','Fue creado por el analista Booch, de ahí su tipo, tras un fallo en el desarrollo de un diagrama de clase. Este javamon es muy observador, le gusta tenerlo todo bajo control y no saltarse ningún detalle.', 10, 190, 62, 16, 1, 4)
		, (22, 'Intellimon', 'programador','Se encarga de ayudar con los programas de la región, mantiene la cohesión y evita las excepciones entre los javamons, para muchos es el más fuerte.', 10, 160, 65, 24, 1, 4)
		, (23, 'Junitson','tester', 'Un javamon al que no le gusta llamar la atención, espera sin hacer ruido pero es capaz de detectar cualquier fallo en sus oponentes. Se lleva especialmente mal con los de tipo programador.', 10, 170, 65, 19, 1, 4)
		, (24, 'Tentafol', 'analista','Un javamon muy preventivo, es capaz de ver las catástrofes antes de que sucedan y poder evitarlas. Velan por la seguridad de todos.', 3, 100, 30, 11, 0, 1)
		, (25, 'Nidoget', 'programador','Es un javamon que muestra mucho sus sentimientos. Junto con su hermano Nidoset hacen una dupla increíble.', 5, 115, 40, 14, 0, 2)
		, (26, 'Nidoset', 'programador','Es un javamon que cambia mucho de personalidad. Junto con su hermano Nidoget hacen una dupla increíble.', 5, 100, 45, 17, 0, 2)
		, (27, 'Metabug', 'tester', 'Un javamon muy singular pero con una característica muy especial, puede solucionar cualquier error . Suele ser el javamon de la policía nacional de Nervionia.', 6, 150, 35, 13, 0, 3)
		, (28, 'Tracerbro', 'tester', 'Es capaz de conectar cualquier red, y su amabilidad permite que este sea de gran ayuda para la región.', 7, 130, 50, 13, 0, 3)
		, (29, 'Virtualrex', 'tester', 'Era el rey de los javamons originales gracias a su habilidad de crear ilusiones de mundos similares al real en el que entrenar su fuerza. Se dice que su primer entrenador fue Jose María hace millones de años.', 8, 145, 60, 14, 0, 3)


  -- Ataques
  INSERT INTO [dbo].[Ataque] -- todos los ataquesque pueden tener los javamons
          ([nombre], [descripcion], [stat], [cantidad])

   VALUES ('asociacion ternaria', 'Provoca danho en el adversario', null, null)
		, ('cobertura de sentencias', 'Provoca danho en el adversario', null, null)
		, ('eclipse', 'Provoca danho en el adversario', null, null)
		, ('generate setter', 'Provoca danho en el adversario', null, null)
		, ('generate getter', 'Provoca danho en el adversario', null, null)
		, ('herencia multiple', 'Provoca danho en el adversario', null, null)
		, ('composiciOn', 'Provoca danho en el adversario', null, null)
		, ('investigacion en bucle', 'Provoca danho en el adversario', null, null)
		, ('contrato temporal', 'Provoca danho en el adversario', null, null)
		, ('rol administrativo', 'Provoca danho en el adversario', null, null)
		, ('try catch', 'Provoca danho en el adversario', null, null)
		, ('implements', 'Provoca danho en el adversario', null, null)
		, ('compilacion perfecta', 'Provoca danho en el adversario', null, null)
		, ('protocolo DHCP', 'Provoca danho en el adversario', null, null)
		, ('test unitario', 'Provoca danho en el adversario', null, null)
		, ('ubuntu', 'Provoca danho en el adversario', null, null)
		, ('hexadecimal', 'Provoca danho en el adversario', null, null)
		, ('Parlamento', 'Provoca danho en el adversario', null, null)
		, ('rugido virtual', 'Provoca danho en el adversario', null, null)
		, ('copia de seguridad', 'Te protege de los ataques del adversario', null, null)
		, ('catchtura', 'Te protege de los ataques del adversario', null, null)
		, ('a', 'Te protege de los ataques del adversario', null, null)
		, ('drive', 'Te protege de los ataques del adversario', null, null)
		, ('visibilidad privada', 'Te protege de los ataques del adversario', null, null)
		, ('caso cerrado', 'Te protege de los ataques del adversario', null, null)
		, ('epi', 'Te protege de los ataques del adversario', null, null)
		, ('rollback', 'Te protege de los ataques del adversario', null, null)
		, ('backup', 'Te protege de los ataques del adversario', null, null)
		, ('instantanea', 'Te protege de los ataques del adversario', null, null)
		, ('binario', 'Te protege de los ataques del adversario', null, null)
		, ('commit', 'Te protege de los ataques del adversario', null, null)
		, ('LeoBarrera', 'Te protege de los ataques del adversario', null, null)
		, ('debugger', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('extends', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('asserto', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('bucle infinito', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('deduccion', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('finally', 'Aumenta el danho de tu javamon', 'danho', 10)
		, ('sobrecarga', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('abstraccion', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('subir nota', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('prevencion de riesgos', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('inclusion', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('enrutamiento', 'Aumenta la salud de tu javamon', 'salud', 10)
		, ('decimal', 'Aumenta mucho la salud de tu javamon', 'salud', 20)
		, ('pastafarismo', 'Aumenta mucho la salud de tu javamon', 'salud', 20)
		, ('modulacion', 'Aumenta la velocidad de tu javamon', 'velocidad', 5)
		, ('monitorizacion', 'Aumenta la velocidad de tu javamon', 'velocidad', 5)




  INSERT INTO [dbo].[JavamonAtaque]	-- ataques de cada javamon
		  ([codigoJavamon], [nombre])

   VALUES (1, 'copia de seguridad')
		, (1, 'abstraccion')
		, (1, 'asociacion ternaria')
		, (2, 'catchtura')
		, (2, 'debugger')
		, (2, 'compilacion perfecta')
		, (3, 'copia de seguridad')
		, (3, 'asserto')
		, (3, 'cobertura de sentencias')
		, (7, 'binario')
		, (7, 'decimal')
		, (7, 'hexadecimal')
		, (8, 'instantanea')
		, (8, 'monitorizacion')
		, (8, 'rugido virtual')
		, (9, 'backup')
		, (9, 'asserto')
		, (9, 'ubuntu')
		, (10, 'commit')
		, (10, 'asserto')
		, (10, 'test unitario')
		, (11, 'copia de seguridad')
		, (11, 'enrutamiento')
		, (11, 'protocolo DHCP')
		, (12, 'rollback')
		, (12, 'extends')
		, (12, 'compilacion perfecta')
		, (13, 'a')
		, (13, 'subir nota')
		, (13, 'eclipse')
		, (14, 'catchtura')
		, (14, 'debugger')
		, (14, 'generate getter')
		, (15, 'catchtura')
		, (15, 'sobrecarga')
		, (15, 'generate setter')
		, (16, 'copia de seguridad')
		, (16, 'modulacion')
		, (16, 'implements')
		, (17, 'rollback')
		, (17, 'finally')
		, (17, 'try catch')
		, (18, 'a')
		, (18, 'inclusion')
		, (18, 'rol administrativo')
		, (19, 'epi')
		, (19, 'prevencion de riesgos')
		, (19, 'contrato temporal')
		, (20, 'drive')
		, (20, 'bucle infinito')
		, (20, 'herencia multiple')
		, (21, 'caso cerrado')
		, (21, 'deduccion')
		, (21, 'investigaciOn en bucle')
		, (22, 'visibilidad privada')
		, (22, 'abstraccion')
		, (22, 'composicion')
		, (23, 'LeoBarrera')
		, (23, 'pastafarismo')
		, (23, 'Parlamento')


 --Creación de usuario para conexiones con al programa de java

	CREATE LOGIN Santi with password='javamaniaco37',
	DEFAULT_DATABASE=Javamon
	USE Javamon
	CREATE USER Santi FOR LOGIN Santi
	GRANT EXECUTE, INSERT, UPDATE, DELETE,
	SELECT TO Santi

	ALTER SERVER ROLE sysadmin
    ADD MEMBER Santi


--Pruebas consultas java
 --SELECT * FROM Entrenador
	WHERE codigoEntrenador = 5

-- borrar entrenador
 --DELETE FROM Entrenador
	--where codigoEntrenador = 5

--insertar 
 --Insert into Entrenador
	--Values (5, 'nombre' , 50, null, 0)

--update
 --UPDATE Entrenador
  --SET dinero = 
	--WHERE codigoEntrenador = 5

-- UPDATE Javamon
-- SET codigoEntrenador = 
--	WHERE codigoJavamon = 5

--SELECT codigoJavamon, nombre, tipo, descripcion, nivel, salud, danho, velocidad, starter, ISNULL (codigoEntrenador, 0) FROM Javamon
--WHERE codigoJavamon = 16

