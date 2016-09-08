<#-- @ftlvariable name="" type="com.kainos.drillone.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Librarian tools</p>

<table class="table">
    <thead>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
    </thead>

    <tbody>
        <#list library as book>
            <tr>
            <td>
                ${book.title}
            </td>
            <td>
                ${book.authorFirstName} ${book.authorSurname}
            </td>
            <td>
                ${book.isbnTen} / ${book.isbnThirteen}
            </td>
            </tr>
        </#list>

    </tbody>
</table>

</@layoutTemplate.layout>