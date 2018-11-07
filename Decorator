1.1  Decorator Compartment

The decorator makes the object transparent at runtime which need to be extended. Clients don’t get the in about the feature enhancements.

?????????????????


                             Figure 1.1 Composite Pattern Class Model

Documentation


It contains DecoratorPattern as  CompartmentType and  GenType data types. The former allows the instantiation of the pattern and includes the role model methods. These allow clients access the roles of the component and the decorators can take over. The class implements own algorithms with the method operation. The clients use methods which
the decorator owns. The class GenericComponent plays the decorator.

The roles in the diagram are Component and decorators. The role Component allows to use the algorithms of its decorators via the useComponent relation.

The Decorator role model has the interface as a component and specifies an interface for concrete decorators. These are the ConcreteDecorator role group. They represent the functions to which the componentcan be extended and implement the methods of the interfaces of Decorator and the Component. They use the implementation of the component class. The roles have their own methods and attributes which are represented by newOperation and newState.

Always there is a class who plays the Component role. A component can participate in the design pattern even without a decorator
if functions are to be added to the component at runtime. From this information
you can derive the occurrence constraints.

Here the role model has an equivalence role. The docorator has an abstract character and has a role equivalence to role group ConcreteDecorator. By the Role Group Constraint of the role group must have classes that take the role of decorator and always plays at least one role of concrete decorators.

There is a role relation useComponent  between Decorator and Component. This expresses the algorithms to be used by decorators. The Component and Decorators together represent the model. The Decorators having Component functions can only played by the class. This has been indicated as reflexive condition.

---------------------------
An instance of Decorator is always uniquely assigned to a component. But the component can have infinite decorators. This is implemented by the roles of concrete decorators.
The Generic Component can have a component with or without the decorator.
 
However, a class can only do the role once
Decorator who owns an abstract character play. Therefore, at the relation as cardinal
Condition on the side of Decorator roll 0 to 1 offered. From these multiplicities




Evaluation

???????????????????


		Figure 1.3  Composite Pattern features in 3 representations


1. The design pattern allows the transparent extension of the functions of a
Object at runtime. The feature is also in the components intention, consequences
and motivation documented by text.  

2. The pattern is used for the functions such that every object of a class don’t need to use.

3. The static inheritance feature extension of a class is not practical.

4. The classes participate in the design pattern are Component, Concrete-Component, decorator and concrete decorators.

5. The Component and Decorator classes are abstract.

6. The ConcreteComponent class inherits from Component. 

7. The class Decorator inherits from Component. 

8. The concrete decorators inherit from the class Decorator.

9. The class Decorator has an aggregation relation to the class Component.

10. The methods of the decorator classes will call methods of their aggregated component and run your own code before or after. 

11. The interface of the abstract decorator class confirms to that of the components.

12. The concrete decorators implement their own algorithms and have their own
Conditions.

13. The Component class provides the interface for the specific components.

14. Decorator Class provides an interface for concrete decorators.

15. The design pattern enables simple through dynamic function extension Classes whose objects are expanded as needed.

16. New features can be added in new decorators regardless of the component to be programmed. This increases the extensibility of the software.

The following features are captured textually in the Implementation section.
17. The distribution of functions generate many small similar objects at runtime.
18. For a method call on the decorator, acts through delegation to the Component. However, the 2 objects are identified differently.

19. With only one concrete decorator, the abstract decorator class is not necessary.

20. The class Decorator should only specify the interface that has all components in common to have. Additional attributes and functionalities complain the decorators.

21. The desing pattern should be used for a complex component class. 

22. The design pattern allows to extend the interface of a component so
that a client can access its normal and advanced features.

23. The participants in the design pattern are ComponentClient, Component, Decorator client and decorator. 

24. There is a role between the roles DecoratorClient and ComponentClient.

25. There is a role between the decorator and component roles. 

26. The role of decorator interacts with the role component. 

27. The ComponentClient interacts with the Component.

28. The role DecoratorClient interacts with the Component and Decorator.

29. The composition constraints from the Role Relationship Matrix [Rie09, p. 29] apply.



The classes mentioned in feature 4 are partially modeled by roles. Thereby, that the Decorator role  has an abstract character and the class GenericComponent
is representative of abstract and concrete classes.There is no knowledge about the roles of a component needs to access. This has been documented in Feature 1.This is the extension of the functions of an object by accepting the additional roles at runtime is completely transparent.



