package edutypes;


import javax.rmi.CORBA.StubDelegate;

// DO NOT MODIFY THIS CLASS
public abstract class Person {}

// Define the following classes without using methods or fields;
// you can make them abstract, interfaces, or concrete classes,
// and you can subtype through extends, implements, or both.
class Instructor {} 

class Professor { }

class Student { }

class TeachingAssistant extends Student{ public TeachingAssistant(){}}
