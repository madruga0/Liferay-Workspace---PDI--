# Project of my IDP - Q1 - 2026

## 🎯 Project Objective
- Set up a Liferay Workspace 7.4
- Create a web module using MVC Portlet
- Work with JSP
- Correctly implement: 
	- Render Command
	- Resource Command
	- Action Command
- Understand the MVC Portlet lifecycle in Liferay

## 📝 Project Scope
The project consists of a **Simple Item Registration Portlet**:
- View a list of items **(Render)**
- Add a new item using a form **(Action)**
- Search items using **AJAX (Resource)**

## 💻 Technologies and Tools  
- Liferay Workspace 7.4
- Java
- JSP | MVC Portlet
- Javascript
- CSS | Bootstrap | SASS
- HTML

## 🚩 Detailed features
### 1 - Render – Item Listing
- **Objective**
	- Display a list of registered items.
- **Requirements**
	- Create an `MVCRenderCommmand`
	- Populate the items list in the `RenderCommand`
	- Render the list in `/list_items.jsp`
	- The list of items must be displayed in a simple table
### 2 - Action – Add New Item
- **Objective**
	- Register a new item using a JSP table.
- **Requirements**
	- Create a form in `form.jsp`
	- Create an `MVCActionCommand`
	- Read parameters using `ParamUtil`
	- Store the item in memory
	- Redirect back to the item listing screen
### 3 - Resource – AJAX Search
- **Objective**
	- Search items dynamically without reloading the page.
- **Requirements**
	- Create an `MVCResourceCommand`
	- Return data in JSON format
	- Consume the endpoint using Javascript (`fetch`)
	- Update the item list on the screen


