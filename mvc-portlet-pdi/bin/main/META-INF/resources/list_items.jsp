<%@ include file="/init.jsp" %>


    <!-- 
Obtendo os atributos da requisição: 
- Valores definidos no ActionCommand e passados para o render via request.setAttribute
-->

    <% String name=(String) request.getAttribute("itemName"); Double price=(Double) request.getAttribute("itemPrice");
        String description=(String) request.getAttribute("itemDescription"); %>

        <div class="container">
            <h1>Items list</h1>

            <%-- Botão para voltar ao formulário --%>
                <portlet:renderURL var="backToFormURL">
                    <portlet:param name="mvcPath" value="/form.jsp" />
                </portlet:renderURL>

                <aui:form>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Item Name</th>
                                    <th>Product Price</th>
                                    <th>Description</th>
                                </tr>
                            </thead>
                            <tbody>

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

                                <tr>
                                    <td>
                                        <%= (name !=null) ? name : "Not informed" %>
                                    </td>
                                    <td>
                                        <%= (price !=null) ? price : "Not informed" %>
                                    </td>
                                    <td>
                                        <%= (description !=null) ? description : "Not informed" %>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </aui:form>


                <a href="${voltarURL}" class="btn btn-secondary">Back to the form</a>
        </div>