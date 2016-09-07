<#-- @ftlvariable name="" type="com.kainos.discoverydiary.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>

<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Books in library</p>

<table class="table">
    <thead>
        <th>Name</th>
        <th>Age</th>
    </thead>

    <tbody>
        <#list people as person>
            <tr>
            <td>
                ${person.name}
            </td>
            <td>
                ${person.age}
            </td>
            </tr>
        </#list>

    </tbody>
</table>

<a class="btn btn-default" href="/people/add">New</a>

</@layoutTemplate.layout>