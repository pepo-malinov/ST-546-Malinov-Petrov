## Софтуерни технологии 2019

Практически проект

### Домашно задание - 1ва седмица

* navbar да се промени като се добави class navbar-dark и bg-light се замени с bg-success
* Да се преработи login страницата (index.html)
* Да се създадат страници съответно profile.html и home.html
* Да се използват лейаутите предоставени в папка design и картинките добавени в images



Setting up the project at home for Eclipse - OS Windows 64bit

Download eclipse jee for windows 64bit
https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-ee-developers
After running the installation select Eclipse for Enterprise development (probably the second choice)

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


Setting up Tomcat server:
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


If there is no jdk on your computer you need to download a jdk for windows 64bit
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html


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

If there is a problem connected with port in use go to the Tab servers at the bottom and double click on Tomcat v9.0 server
On the right there will be a Port Number for HTTP/1.1 which by default is 8080
Enter 8181 or 8888 save and try to rerun the project on the server