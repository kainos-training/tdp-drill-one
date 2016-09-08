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
        <label for="title">Book Title</label>
        <input name="title" type="text" placeholder="Book Title" class="form-control" required />
    </div>

    <div class="form-group">
        <label for="authorFirstName">Author First Name</label>
        <input name="authorFirstName" type="text" placeholder="Author First Name" class="form-control" required />
    </div>

    <div class="form-group">
         <label for="authorLastName">Author Last Name</label>
         <input name="authorLastName" type="text" placeholder="Author Last Name" class="form-control" required />
    </div>

    <div class="form-group">
        <label for="ISBN10">10-digit ISBN</label>
        <input name="ISBN10" type="text" placeholder="ISBN" class="form-control" />
        <p class="help-block">E.g. 9482762512</p>
    </div>

    <div class="form-group">
        <label for="ISBN13">13-digit ISBN</label>
        <input name="ISBN13" type="text" placeholder="ISBN" class="form-control" />
        <p class="help-block">E.g. 978-9482762512*</p>
    </div>

    <input type="submit" value="Add Book" class="btn btn-primary" />
    <a class="btn btn-default" href="/books/librarian">Cancel</a>

</form>
</@layoutTemplate.layout>