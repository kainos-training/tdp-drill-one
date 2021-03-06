<#-- @ftlvariable name="" type="com.kainos.drillone.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>


<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Books</p>

<table class="table">
    <thead>
        <th>
        </th>
    </thead>

    <tbody>
         <#list library as book>
                    <tr>
                    <td>
                        <b>${book.title}</b>
                        <br>
                        by ${book.authorFirstName} ${book.authorSurname}
                        <br>
                        ISBN10: ${book.isbnTen}
                         <br>
                        ISBN13: ${book.isbnThirteen}
                        <br>
                        <a href="/books/update?id=${book.id}" class="btn btn-default">Update</a>
                    </td>
                    </tr>
        </#list>
    </tbody>
</table>
</@layoutTemplate.layout>

<script type="text/javascript">
    $(document).ready(function(){
        $(".table").DataTable({
            "bPaginate": false,
            "bLengthChange": false,
            "ordering": false,
        });
    });
</script>
