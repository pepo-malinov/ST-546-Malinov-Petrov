## Софтуерни технологии 2019

Практически проект

### Домашно задание - 1ва седмица

* navbar да се промени като се добави class navbar-dark и bg-light се замени с bg-success
* Да се преработи login страницата (index.html)
* Да се създадат страници съответно profile.html и home.html
* Да се използват лейаутите предоставени в папка design и картинките добавени в images


=============================================================

ас. Пенчо Малинов

email: pepo.malinov@gmail.com

ас. Александър Петров

email: apetrovdev.@gmail.com

skype: alexppetrov



### Setting up the project at home for Eclipse - OS Windows 64bit

## Download eclipse jee for windows 64bit

https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-ee-developers
After running the installation select Eclipse for Enterprise development (probably the second choice)

## Cloning the project

Open eclipse and select Window -> Perspective -> Other Perspective -> Other -> Git

On the left should be a panel Git Repositories (if there is no such a panel go to Window -> Perspective -> Reset Perspective)

Select - Clone a Git repository

Paste the following git link in URI:

https://github.com/pepo-malinov/ST-546-Malinov-Petrov.git

Next -> Next -> Finish

Go to Window -> Perspective -> Other perspective -> Web  (or use the shortcut on the right next to git shortcut)

On the right there should be the cloned project within a panel Project Explorer

(If the panel is not visible go to WIndow -> Perspective -> Reset Perspective)


Go to File -> Open Projects from File System -> Choose directory and navigate to the folder where the project was cloned and select Finish


## Setting up Tomcat server

https://tomcat.apache.org/download-90.cgi

Choose the zip file for Windows 64bit

Download and extract to a folder

Go to eclipse and find the tab servers at the bottom. Select and there will be a link to Create a new server

In the field select the server type: type in tomcat and select tomcat v9.0 server

Choose tomcat installation directory and browse to the extracted tomcat server folder and click Finish

Go to Window -> Preferences -> Java -> Installed JRE-s

There will be one jre file listed. Select and Remove it

Click on Add.. Choose Standard VM (3-rd option)

For JRE home: click on Directory…
and find your jdk it should be within Program Files / java / jdk1.8…. And select the folder

Click on Finish

Make sure that the newly added jdk in the list is checked

    [ ] jdk1.8…..

Click Apply and Close

*If there is no jdk on your computer you need to download a jdk for windows 64bit*

*https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html*


Select the project within the Project explorer. Right click and choose properties

Go to project facets and click on Convert to faceted form…

Mark the options:

    [ ] Dynamic web module

    [ ] Java

    [ ] Javascript

Click on  Dynamic web module

There will be a tab on the right “runtimes” select tomcat

Apply and Close

Right click on the project within the Project explorer panel then  > Run as > Run on server and press Finish

*If there is a problem connected with port in use go to the Tab servers at the bottom and double click on Tomcat v9.0 server
On the right there will be a Port Number for HTTP/1.1 which by default is 8080
Enter 8181 or 8888 save and try to rerun the project on the server*


## Adding H2 Database to the project

Download the latest stable version

Platform-Independent Zip from

http://www.h2database.com/html/download.html

Extract the zip file and add the h2-1.4.199jar to the project within the folder

WebContent > WEB-INF > lib

Right click and add the jar file -> Build Path -> Add to Build path

## Connecting to a Database using JDBC

http://www.h2database.com/html/tutorial.html#connecting_using_jdbc

## Adding hibernate ORM to the project

Download core jar files from:

https://jar-download.com/artifacts/org.hibernate/hibernate-core/5.3.1.Final/source-code

Add all the jar files to WEB-INF -> lib

Select the jar files, Right click and add the jar file -> Build Path -> Add to Build path

*If no actions are available go to the project root directory -> Right click go to properties and Build path and add the jars manually

Right click on the project go to Project facets and mark

    [ ] JPA

Configure JPA Facet and at JPA implementation chose

    [ ] Disable Library Configuration

At the bottom Persistent class management mark

    [ ] Annotated classes must be listed in persistence.xml

Then click ok

In Java Resources -> src -> META-INF a persistence.xml should be added

The configuration made in the persistence.xml file should be similar to:

https://gist.github.com/jorgevs/218483e7ba854e8e6e23be18182b0381

for reference use the one within our current project

=============================================================

### ЗАДАНИЕ ПРАКТИКУМ МАГИСТРИ 2019/2020

За получаване на оценка по дисциплината „Практукум“ студентите трябва да подготвят
проект, изпълнявайки следните задачи:

    * Намиране (или изграждане на свое) API, което да връща информация в JSON формат.

    * Изграждане на HTML страница съдържаща форма с полета, които се използват за изпращане на заявка към API-то от т.1. Точният вид на формата и нейните полета се определят от студентите, но задължително условие е да съществува начин за филтриране на информацията върната от външния сървис(това може да стане с <select> или radio buttons или checkboxes).

    * При натискане на бутон submit или промяна на полетата във формата се изпраща ajax заявка към сървиса и върната информация се визуализира под формата.

    * Над или отстрани на полето, в което се визуализира информацията да има бутон, позволяващ промяна на изгледа на визуализираните данни. Пример: ако информацията, която получаваме се визуализира под формата на квадратчета с картинка и информация под нея, при натискане на бутона, същата информация да се визуализира под формата на редове с картинка и информация до нея.

За разработката на проекта използвайте HTML, CSS, JavaScript, Bootstrap, JQuery, Ajax.
Проектът трябва да е качен в github и да бъде представен лично до 08.12.2019г. Проектът е предвиден за самостоятелна работа, съответно всички предаващи проекти ще бъдат изпитвани относно функционалностите и работата на проекта

### Пример

За реализация е използвано следното API

https://www.themoviedb.org/documentation/api?language=en-US

Графичният интерфейс има следната функционалност:

избор на година, сортиране по критерий като "популярност", търсене по жанр и визуализиране на върнатите резултати

![alt text](https://raw.githubusercontent.com/pepo-malinov/ST-546-Malinov-Petrov/master/ST2019_WeatherApp/WebContent/design/example.png)

Като в примера е изпълнен следният request

https://api.themoviedb.org/3/discover/movie?year=2019&api_key=ca3d69ee336e43d8099727f0d7ce3859