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

#### For Eclipse or NetBeans Users:

* Well... Eclipse sucks!
* IDK where the src folder for Eclipse is. 
* Download [IntelliJ IDEA](https://www.jetbrains.com/idea/) for free [here](https://www.jetbrains.com/idea/download/).
* And if you're a student like me, you can get a free IntelliJ Ultimate license with your school email [here](https://www.jetbrains.com/student/).

#### For BlueJ, Notepad++ Users:

* IDE is not just a text editor.
* ... and don't say "I can use `javac`."

#### For Visual Studio Users:

* Have you tried turning it off and on again?

#### Others:

* Stop telling me "I use `mspaint` to code Java."

### Veracross SDK:

```java
// Import packages first:
//   import cc.moecraft.school.veracross.*;
//   import cc.moecraft.school.veracross.pojo.*;

// Initialize object with base url, username and password.
VeracrossReader reader = new VeracrossReader("https://portals-app.veracross.com/schoolname", "username", "password");

// Initialize browser driver with the path to chrome driver.
// The boolean means use headless mode or not.
//   true = Headless, false = Not headless.
//   I recommend false when debugging and true when deploying.
//   Because if it's headless, you can't see the browser window.
reader.initialize("./GPACalc.Core/drivers/chromedriver.exe", true);

// Login to Veracross
reader.login();

// Get course list
List<VeracrossCourse> courses = reader.getCourses();
log(courses);

// Get assignments of the course at index 1 of the list.
VeracrossAssignments assignments = reader.getAssignments(courses.get(1).getAssignmentsId());
log(assignments);

// Get messages starting at index 0.
List<VeracrossMessage> messages = reader.getMessages(0);
log(messages);

// Get calendar events from 5 days ago to 5 days later.
List<VeracrossCalendarEvent> events = reader.getEvents(-5, 5);
log(events);

// Get calendar events from a specific date to a specific date.
events = reader.getEvents(new Date(), new Date());
log(events);

// Kill browser task.
reader.destroy();
```

### GPA Calculating:

#### 1. Write a Grading Profile:

```yml
# A grading profile shows how a school weight their levels.
# This example is for a weighted high school.

# The level of courses.
# Key word can be anything.
# Grade weights are how much credit do you get for each grade.
Levels:
  AdvancedPlacement:
    Alias:
    - "AP"
    GradeWeight:
      A+: 5
      A:  4.75
      A-: 4.5
      B+: 4.25
      B:  4
      B-: 3.75
      C+: 3.5
      C:  3.25
      C-: 3
      D:  2
      F:  0

  Honors:
    Alias:
    - "H"
    GradeWeight:
      A+: 4.75
      A:  4.5
      A-: 4.25
      B+: 4
      B:  3.75
      B-: 3.5
      C+: 3.25
      C:  3
      C-: 2.75
      D:  1.75
      F:  0

  Accelerated:
    Alias:
    - "Acc"
    - "A"
    GradeWeight:
      A+: 4.5
      A:  4.25
      A-: 4
      B+: 3.75
      B:  3.5
      B-: 3.25
      C+: 3
      C:  2.75
      C-: 2.5
      D:  1.5
      F:  0

  CollegePrep:
    Alias:
    - "CP"
    GradeWeight:
      A+: 4.25
      A:  4
      A-: 3.75
      B+: 3.5
      B:  3.25
      B-: 3
      C+: 2.75
      C:  2.5
      C-: 2.25
      D:  1.25
      F:  0

# The ranges of the grade.
# The value represents the minimum amount in the range.
# For example, A+ would be 97 - 100, so put 97 as the value.
GradeRanges:
  A+: 97
  A:  93
  A-: 90
  B+: 87
  B:  83
  B-: 80
  C+: 77
  C:  73
  C-: 71
  D:  70
  F:  0
```

#### 2. Write a Student Profile:

```yml
# A student profile shows what courses a student chose.
# This example is the courses I chose.

# Basic information, doesn't affect calculating.
Basics:
  Name: "This is not important"
  Grade: 10
  Semester: 1

# Courses a student is taking.
Subjects:
  English:
    Name: "English 2 A"
    Level: "A"
    Credits: 1
  Algebra:
    Name: "Algebra 2 H"
    Level: "H"
    Credits: 1
  Chemistry:
    Name: "Chemistry 1 H"
    Level: "H"
    Credits: 1
  History:
    Name: "Modern World History CP"
    Level: "CP"
    Credits: 1
  Religion:
    Name: "Early Church CP"
    Level: "CP"
    Credits: 0.5
  ComputerScience:
    Name: "AP Computer Science A"
    Level: "AP"
    Credits: 1
```
