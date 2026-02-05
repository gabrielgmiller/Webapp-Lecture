<#import "/spring.ftl" as spring/>
<#include "template.ftlh">
<#macro content>
	<h3>Add Author</h3>
	<@showSuccess/>
	<@showError/>
	<form action="/addAuthor" method="POST">
    	<div class="mb-3">
        	<label for="firstName">First name</label>
        	<@spring.formInput "authorBean.firstName" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
    	<div class="mb-3">
	        <label for="lastName">Last name</label>
        	<div><@spring.formInput "authorBean.lastName" "class='form-control'"/></div>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
    	<button type="submit" class="btn btn-primary mb-3">Add</button>
	</form>
</#macro>
<@template/>