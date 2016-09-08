<#-- @ftlvariable name="" type="com.kainos.drillone.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Librarian tools</p>

<table class="table">
    <thead>
        <th>Unique book id</th>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN 10</th>
        <th>ISBN 13</th>
    </thead>

    <tbody>
        <#list library as book>
            <tr>
            <td>
                ${book.id}
            </td>
            <td>
                ${book.title}
            </td>
            <td>
                ${book.authorFirstName} ${book.authorSurname}
            </td>
            <td>
                ${book.isbnTen}
            </td>
            <td>
                ${book.isbnThirteen}
            </td>
            </tr>
        </#list>

    </tbody>
</table>

</@layoutTemplate.layout>