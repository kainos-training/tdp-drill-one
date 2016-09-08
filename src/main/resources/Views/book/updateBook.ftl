<#import "../layout.ftl" as layoutTemplate>
<#-- @ftlvariable name="book" type="com.kainos.drillone.views.BookUpdateView" -->

<@layoutTemplate.layout>

<h1>Update a book</h1>
<p class="lead">Please update the appropriate details of the book.</p>

<form enctype="multipart/form-data" action="/books/update" method="post" autocomplete="off">

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
        <label for="authorFirstName">Author First name</label>
        <input name="authorFirstName" type="text" placeholder="author" class="form-control" required value ="${book.authorFirstName}" />
    </div>
    <div class="form-group">
        <label for="authorSurname">Author Surname</label>
        <input name="authorSurname" type="text" placeholder="author" class="form-control" required value ="${book.authorSurname}" />
    </div>
    <div class="form-group">
        <label for="ISBNTen">ISBN Ten</label>
        <input name="ISBNTen" type="text" placeholder="ISBN" class="form-control" value ="${book.isbnTen}"/>
     </div>
    <div class="form-group">
             <label for="ISBNThirteen">ISBN Thirteen</label>
             <input name="ISBNThirteen" type="text" placeholder="XXX-XXXXXXXXXXX" class="form-control"
             value ="${book.isbnThirteen}"/>
    </div>

    <input type="submit" value="Confirm" class="btn btn-primary" />
    <a class="btn btn-default" href="/book/librarian">Cancel</a>

</form>


</@layoutTemplate.layout>