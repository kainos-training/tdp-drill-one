<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>Add a book</h1>
<p class="lead">Please provide details of the book.</p>

<form enctype="multipart/form-data" action="/books/addbook" method="post" autocomplete="off">

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

    <input type = "hidden" name="ID" type="text" />

    <div class="form-group">
        <label for="title">Title</label>
        <input name="title" type="text" placeholder="Title" class="form-control" required />
    </div>

    <div class="form-group">
        <label for="authorFirstName">Author first name</label>
        <input name="authorFirstName" type="text" placeholder="Author first name" class="form-control" required />
    </div>

    <div class="form-group">
         <label for="authorLastName">Author surname</label>
         <input name="authorLastName" type="text" placeholder="Author surname" class="form-control" required />
    </div>

    <div class="form-group">
        <label for="ISBN10">ISBN-10</label>
        <input name="ISBN10" type="text" placeholder="ISBN" class="form-control" />
        <p class="help-block">E.g. 9482762512</p>
    </div>

    <div class="form-group">
        <label for="ISBN13">ISBN-13</label>
        <input name="ISBN13" type="text" placeholder="ISBN" class="form-control" />
        <p class="help-block">E.g. 978-9482762512*</p>
    </div>

    <input type="submit" value="Add book" class="btn btn-primary" />
    <a class="btn btn-default" href="/books/librarian">Cancel</a>

</form>
</@layoutTemplate.layout>