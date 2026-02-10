<%@ include file="/init.jsp" %>

    <portlet:actionURL name="saveItem" var="addItemActionURL" />
    <portlet:renderURL var="showItemsRenderURL">
        <portlet:param name="mvcRenderCommandName" value="showItems" />
    </portlet:renderURL>
    <portlet:resourceURL var="listAllItens" id="saveItem" />


    <div class="page">
        <header class="form-header text-center">
            <h1>Add new item</h1>
            <p>Set the basic informations to register a new item.</p>
        </header>

        <aui:form class="form" action="${addItemActionURL}" method="post" name="fm">
            <div class="field-group">
                <div class="text-div mb-3">
                    <label for="text-input">Item name <span>*</span></label>
                    <input class="form-control" type="text" name="<portlet:namespace />itemName"
                        id="<portlet:namespace />itemName" placeholder="Ex: Logitec Mouse" required>
                </div>

                <div class="fieldset-div mb-4">
                    <label>Description</label>
                    <textarea class="form-control" name="<portlet:namespace />description"
                        placeholder="Describe your product here"></textarea>
                </div>

                <div class="btn-group d-flex justify-content-around">
                    <aui:button type="submit" cssClass="btn btn-success" value="Add Item" id="submitBtn" />
                    <a type="button" class="btn btn-secondary" href="<%= showItemsRenderURL %>" id="itemsList">See list
                        items</a>
                </div>
            </div>
        </aui:form>

        <script>
            const saveItem = () => {
                const name = document.querySelector('[name$="itemName"]').value;
                const description = document.querySelector('[name$="description"]').value;

                fetch('<%= listAllItens %>', {
                    method: 'POST',
                    body: new URLSearchParams({
                        '<portlet:namespace />itemName': name,
                        '<portlet:namespace />description': description
                    })
                })
                    .then(response => response.json())
                    .then(data => {
                        console.log('Items total: ', data.total)
                        console.log(data.json());
                    })
            }
        </script>
    </div>