<#-- @ftlvariable name="" type="com.kainos.drillone.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Books in library</p>

<table class="table">
    <thead>
        <th>Author</th>
        <th>Title</th>
    </thead>

    <tbody>
        <#list books as book>
            <tr>
            <td>
                ${book.Title}
            </td>
            <td>
                ${book.Title}
            </td>
            </tr>
        </#list>

    </tbody>
</table>

</@layoutTemplate.layout>