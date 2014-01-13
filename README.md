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
