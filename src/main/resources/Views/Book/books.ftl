<#-- @ftlvariable name="" type="com.kainos.drillone.views.BookView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>People list</h1>
<p class="lead">Registered people.</p>

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
                ${book.authorfirstName} ${book.authorSurname}
            </td>
            <td>
                ${book.isbnTen}
            </td>
            </tr>
        </#list>

    </tbody>
</table>

<a class="btn btn-default" href="/people/add">New</a>

</@layoutTemplate.layout>