<%@include file="head.jsp"%>
<html>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp"%>
    <h1>Speedy Grocery Shopper</h1>
    <div id="form">
        <form action="" method="POST">
            <label for name="name">Template Name: </label>
            <input type="text" name="name" />
            <label for name="catagory">Catagory: </label>
            <input type="text" name="catagory">
            <br /><hr />
            <div id="firstgroup">
                <label for name="foodgroupname">Food Group name: </label>
                <input type="text" name="foodgroup1" /><br />
                <label for name="ingredient">Ingredient: </label>
                <input type="text" name="ingredient1" /><br />
                <input type="button" id="addnewingredient" value="Add Another Ingredient">
            </div>

            <hr />
            <div id="foodgroup">
                <input type="button" id="addnewfoodgroup" value="Add Another Food Group">
            </div>
            <hr />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </div>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
<script src="javascript/newTemplate.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
    init();
</script>