<#import "../layout.ftl" as layoutTemplate>

    <@layoutTemplate.layout>

    <h1>Borrow a book</h1>
    <p class="lead">Please enter your name.</p>

    <form enctype="multipart/form-data" action="/books/borrowbook" method="post" autocomplete="off">

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

        <input type ="hidden" name="Id" type="text" />

        <div class="form-group">
            <label for="borrower">Borrower Name</label>
            <input name="borrower" type="text" placeholder="Borrower Name" class="form-control" required />
        </div>

            <input type="submit" value="Borrow Book" class="btn btn-primary" />
            <a class="btn btn-default" href="/books/librarian">Cancel</a>

    </form>
</@layoutTemplate.layout>