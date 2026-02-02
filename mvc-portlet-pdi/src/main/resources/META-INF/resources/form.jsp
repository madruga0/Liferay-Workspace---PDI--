<%@ include file="/init.jsp" %>

	<div class="page">
		<header class="form-header">
			<h1>Add new item</h1>
			<p>Set the basic informations to register a new item.</p>
		</header>
		<aui:form class="form" id="aui_form">
			<div class="field-group">
				<div class="text-div">
					<label for="text-input">Item name</label>
					<input class="text" type="text" id="text-input" name="text-input" required>
				</div>

				<div class="price-div">
					<label for="price-input">Product price</label>
					<input class="price-input" type="number" id="price-input" name="price-input" required>
				</div>

				<div class="fieldset-div">
					<label for="description-input">Description</label>
					<textarea name="description" id="description" placeholder="Describe your product here"></textarea>
				</div>

				<div>
					<div class="col-12">
						<div class="btn-group d-flex" role="group">
							<aui:button id="sendBtn" type="submit" value="Add Item" cssClass="btn-success" />
							<aui:button id="cancelBtn" type="cancel" value="Cancel" cssClass="btn-danger" />
							<aui:button id="seeItemsList" value="See list items" cssClass="btn-info" />
						</div>
					</div>
				</div>
			</div>
		</aui:form>
	</div> 

