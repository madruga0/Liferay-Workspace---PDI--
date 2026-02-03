<%@ include file="/init.jsp" %>

    <portlet:actionURL name="saveItem" var="addItemActionURL" />

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

                <div class="price-div mb-3">
                    <label for="price-input">Product price <span>*</span></label>
                    <input class="form-control" type="number" name="<portlet:namespace />productPrice"
                        placeholder="U$ 0.00" required>
                </div>

                <div class="fieldset-div mb-4">
                    <label>Description</label>
                    <textarea class="form-control" name="<portlet:namespace />description"
                        placeholder="Describe your product here"></textarea>
                </div>

                <div class="btn-group d-flex justify-content-end gap-2">
                    <button type="submit" class="btn btn-success">Add Item</button>
                    <button class="btn btn-secondary">List items</button>
                </div>
            </div>
        </aui:form>
    </div>