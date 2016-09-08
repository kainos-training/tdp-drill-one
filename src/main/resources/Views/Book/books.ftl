<#-- @ftlvariable name="" type="com.kainos.drillone.views.LibrarianView" -->
<#import "../layout.ftl" as layoutTemplate>


<@layoutTemplate.layout>

<h1>KLibrary</h1>
<p class="lead">Librarian tools</p>

<table class="table">
    <thead>
        <th>
        </th>
    </thead>

    <tbody>
         <#list library as book>
                    <tr>
                    <td>
                    <!-- Remove this when adding images datatable -->
                            <div class="books_img">
                                    <!-- <img src="/assets/images/book.png" alt="Book"> -->
                                    <img src="/assets/images/default.png" alt="Image of the Book">
                            </div>
                        <b>${book.title}</b>
                        <br>
                        by ${book.authorfirstName} ${book.authorSurname}
                        <br>
                        ISBN10: ${book.isbnTen}
                         <br>
                        ISBN13: ${book.isbnThirteen}
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