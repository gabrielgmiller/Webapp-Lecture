<#import "/spring.ftl" as spring/>
<#include "template.ftlh">
<#macro content>
	<h3>Add Book</h3>
	<@showSuccess/>
	<@showError/>
	<form action="/addBook" method="POST">
    	<div class="mb-3">
        	<label for="title">Title</label>
        	<@spring.formInput "bookBean.title" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
    	<div class="mb-3">
	        <label for="isbn13">ISBN 13</label>
        	<@spring.formInput "bookBean.isbn13" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
    	<div class="mb-3">
	        <label for="publisher">Publisher</label>
        	<@spring.formInput "bookBean.publisher" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
    	<div class="mb-3">
	        <label for="numberOfPages">Number of pages</label>
        	<@spring.formInput "bookBean.numberOfPages" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
     	<div class="mb-3">
	        <label for="publishedDate">Published at</label>
        	<@spring.formInput "bookBean.publishedDate" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
        <div class="mb-3">
	        <label for="language">Language</label><br>
            <@spring.formRadioButtons "bookBean.language" languages "&nbsp;"/>
            <@spring.showErrors "<br>" "text-danger"/>
        </div>
    	<div class="mb-3">
	        <label for="price">Price</label>
        	<@spring.formInput "bookBean.price" "class='form-control'"/>
        	<@spring.showErrors "<br>" "text-danger"/>
    	</div>
        <div class="mb-3">
	        <label for="authorId">Author</label>
            <@spring.formSingleSelect "bookBean.authorId" authors "class='form-control'"/>
            <@spring.showErrors "<br>" "text-danger"/>
        </div>
    	<button type="submit" class="btn btn-primary" name="button" value="addAuthor">Add Author</button>
	    <table class="table table-striped table-hover table-responsive ">
	        <#list selectedAuthors>
        	<tr>
            	<th>Id</th>
            	<th>First name</th>
            	<th>Last name</th>
            	<th></th>
            </tr>
        	<#items as author>
        	<tr>
            	<td>${author.id}</td>
            	<td>${author.firstName}</td>
            	<td>${author.lastName}</td>
            	<td><button type="submit" class="btn btn-primary" name="button" value="${author.id}">Delete Author</button></td>
            </tr>
        	</#items>
        	</#list>
        </table>
   	<button type="submit" class="btn btn-primary" name="button" value="addBook">Add Book</button>
	</form>
</#macro>
<@template/>