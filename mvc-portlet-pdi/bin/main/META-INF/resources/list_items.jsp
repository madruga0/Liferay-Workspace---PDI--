<%@ include file="/init.jsp" %>
    <%@ page import="java.util.List" %>
        <%@ page import="mvc.portlet.pdi.model.ItemProduct" %>
            <% List<ItemProduct> items = (List<ItemProduct>) request.getAttribute("items");
                    %>

                    <style type="text/css">
                        * {

                            /* Declared variables */
                            --grey-color: #a0a0a0;
                            --green: #287d3c;
                            --white: #ffffff;
                        }

                        table,
                        th,
                        td {
                            border: 1px solid var(--grey-color);
                            padding: 8px 10px;
                        }

                        .table thead th {
                            background-color: var(--green);
                            color: var(--white);
                        }
                    </style>
                    <div class="container">
                        <h1>Items list</h1>

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Item Name</th>                     
                                        <th>Description</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <% if (items !=null && !items.isEmpty()) { %>
                                        <% for (ItemProduct item : items) { %>
                                            <tr>
                                                <td>
                                                    <%= item.getItemName() %>
                                                </td>
                                                <td>
                                                    <%= item.getItemDescription() %>
                                                </td>
                                            </tr>
                                            <% } %>
                                                <% } else { %>
                                                    <tr>
                                                        <td colspan="3" style="text-align:center;">
                                                            No items registered
                                                        </td>
                                                    </tr>
                                                    <% } %>

                                </tbody>
                            </table>
                        </div>
                    </div>