Use JavaSDK19, JavaJDK17.0.4
Supporting application:
-	IntelliJ as the compiler
-	SceneBuilder for building the interface
-	XAMPP for designing and creating the database
Supporting library:
-	Use the JavaFX library for programming
-	Use the fontawesome library to support the SceneBuilder in designing the interface.
-	Use the SQL connector library to connect the database
Guidelines on how to use the software:
-	Download the attached ‘database_pharmacy.sql’ file 
-	Add the database into http://localhost/phpmyadmin/
-	Edit the pathway to the library folder of  JavaFX:
	o	Select Run  Edit Configurations
	o	Click on the + icon and select Application  point to the file launcher
	o	Select Modify options  click on Add VM options
	o	Add --module-path “path”  --add-modules javafx.controls,javafx.fxml whereas ‘path’ is the pathway to the library folder of  JavaFX.
	o	Click Apply  OK
-	Start by running the ‘launcher.java’ file
