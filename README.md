@JsonResponse & @JsonMixin
==========================

**Jackson mixin** support for spring controllers using annotations.

Example
=======

Simply annotate your @RequestMapping method with @JsonResponse and pass an array of @JsonMixin's to apply.

``` java
	@RequestMapping("/customers/summary")
	@JsonResponse(mixins = {
			@JsonMixin(target=Customer.class, mixin=Customer.SummaryMixin.class),
			@JsonMixin(target=Address.class, mixin=Address.SummaryMixin.class)
	})
	public @ResponseBody List<Customer> listSummary()
	{
		return data;
	}
```
	
Servlet Configuration
---------------------

Modify your spring configuration as follows:
``` xml
	<mvc:annotation-driven>
		<mvc:message-converters>
			<beans:bean class="au.id.jackmatthews.jsonresponse.JsonResponseAwareJsonMessageConverter" />
		</mvc:message-converters>
	</mvc:annotation-driven>
	
	<beans:bean class="au.id.jackmatthews.jsonresponse.JsonResponseSupportFactoryBean" />
```

Which Project?
==============
The project comes as a Spring MVC application with an example mapping, you can import the projects into STS and test the generated WAR file on your server.  

Too add the code to your own project all you need is the src/main/java folder from the **core** project and the src/main/java folder from either project **spring3jackson1** or **spring4jackson2**.  You also need to make the spring configuration chages above.  You can delete the **au.id.jackmatthews.jsonresponse.example** package completely.

You will aso need to add the guava maven dependency to your project:
``` xml
                <dependency>
                        <groupId>com.google.guava</groupId>
                        <artifactId>guava</artifactId>
                        <version>13.0.1</version>
                </dependency> 
```

> __core__ - required
> 
> __spring3jackson1__ - for Spring 3.x and Jackson 1.9.x
> 
> __spring4jackson2__ - for Spring 4.x and Jackson 2.x
>
> You will have to do a mix and match of the source code if you are using a different configuration 
> (say Spring 3.x > and Jackson 2.x)

Acknowledgements
================
The project is based on the @ResponseView project by martypitt
https://github.com/martypitt/JsonViewExample
