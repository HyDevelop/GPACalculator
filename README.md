<h1 align="center"><br><br>
  GPA Calculator
</h1>

<h4 align="center">
  A GPA Calculator + Veracross SDK Library + Web UI in Java
</h4>

<h5 align="center">
  <a href="#intro">Introduction</a>&nbsp;&nbsp;
  <a href="#development">Development</a>&nbsp;&nbsp;
  <a href="#license">License</a>
</h5><br><br><br>


<a name="intro"></a>
Introduction:
--------

* This is a project built to calculate GPA.
* GPACalc.Core module is for calculation, and importing from Veracross.
* GPACalc.UI module is for web user interface.
* GPACalc.Discord module is not implemented yet.

### Features:

| Module | Feature |
| :-: | :- |
| Core | Calculate GPA based on a student profile, a grading profile, and grades. |
| Core | Import student profile and grading profile from YAML. |
| Core | SDK for accessing Veracross API. |
| UI | Login via Google and keep user data with Google ID. |
| UI | Edit settings for student profile and grading profile. |
| UI | Enter grades and calculate. |
| UI | TODO: Enter username and password to import from Veracross. |
|  |  |

<br>

<a name="development"></a>
Development:
--------

### Setting Up:

#### For IntelliJ IDEA Users:

* I didn't set up a Maven repo yet, so you have to manually copy some files.
* Clone or download this repo as a zip first if you don't want to copy all code manually.
* Just copy the `src/main/java` folder of the module you want to import to your `src/main/java` folder.
* Then copy the Maven dependencies from the `pom.xml` of the module you want to your `pom.xml`.

#### For Eclipse Users:

* Well... Eclipse sucks!
* IDK where the src folder for Eclipse is. 
* Download [IntelliJ IDEA](https://www.jetbrains.com/idea/) for free [here](https://www.jetbrains.com/idea/download/).
* And if you're a student like me, you can get a free IntelliJ Ultimate license with your school email [here](https://www.jetbrains.com/student/).

#### For NetBeans, BlueJ, Visual Studio, Notepad, and Mspaint Users:

* Kill yourself.

### Veracross:

```java

```
