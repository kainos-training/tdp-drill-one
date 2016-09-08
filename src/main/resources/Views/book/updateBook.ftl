<#import "../layout.ftl" as layoutTemplate>
<#-- @ftlvariable name="book" type="com.kainos.drillone.views.BookUpdateView" -->

<@layoutTemplate.layout>

<h1>Update a book</h1>
<p class="lead">Please update the appropriate details of the book.</p>

<form enctype="multipart/form-data" action="/book/update" method="post" autocomplete="off">

    <#if errors??>
        <div class="bg-danger text-danger">
            <ul>
            <#list errors as error>
                <li>
                    ${error}
                </li>
            </#list>
            </ul>
        </div>
    </#if>

    <input type="hidden" name="id" value="${book.id}" />

    <div class="form-group">
        <label for="title">Title</label>
        <input name="title" type="text" placeholder="title" class="form-control" required value ="${book.title}"/>
    </div>
    <div class="form-group">
        <label for="author">Author</label>
        <input name="author" type="text" placeholder="author" class="form-control" required value ="${book.author}" />
    </div>
    <div class="form-group">
        <label for="ISBNTen">ISBN Ten</label>
        <input name="ISBNTen" type="text" placeholder="title" class="form-control" value ="${book.ISBNTen}"/>
     </div>
     <div class="form-group">
             <label for="ISBNThirteen">ISBN Thirteen</label>
             <input name="ISBNThirteen" type="text" placeholder="title" class="form-control"
             value ="${book.ISBNThirteen}"/>
     </div>

    <input type="submit" value="Confirm" class="btn btn-primary" />
    <a class="btn btn-default" href="/people">Cancel</a>

</form>


</@layoutTemplate.layout>