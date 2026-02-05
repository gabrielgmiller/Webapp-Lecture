<#import "/spring.ftl" as spring/>
<#include "template.ftlh">
<#macro content>
	<h3>Search Products</h3>
	<@showSuccess/>
	<@showError/>
	<form action="searchProducts" method="POST">
	<div class="row mb-3">
        <div class="col">
            <@spring.formSingleSelect "productBean.searchIn" searchOptions "class='form-control'"/>
        </div>
        <div class="col">
            <@spring.formInput "productBean.search" "placeholder='Search Text' class='form-control'"/>
        </div>
        <div class="col">
            <button type="submit" class="btn btn-primary name="search" value="search">Search</button>
        </div>
    </div>
    </form>
	<form action="/addToCart" method="POST">
    <table class="table table-striped table-hover table-responsive ">
        <#list products>
        <tr>
            <th>Title</th>
            <th>Name</th>
            <th></th>
            <th></th>
            </tr>
        <#items as book>
        <tr>
            <td>${book.title}</td>
            <td>${book.firstAuthor.firstName!} ${book.firstAuthor.lastName!}</td>
            <td><button type="submit" class="btn btn-primary" name="selectedProduct" value="show ${book.isbn13}">Show details</button></td>
            <td><button type="submit" class="btn btn-primary" name="selectedProduct" value="add ${book.isbn13}">Add to cart</button></td>
            </tr>
        </#items>
        </#list>
    </table>
	</form>
</#macro>
<@template/>