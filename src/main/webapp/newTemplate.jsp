<%@include file="head.jsp"%>
<html>
<body>
<div id="wrapper">
    <%@include file="navigation.jsp"%>
    <h1>Speedy Grocery Shopper</h1>
    <div>
        <form action="" method="POST">
            <label for name="name">Template Name: </label>
            <input type="text" name="name" />
            <label for name="catagory">Catagory: </label>
            <input type="text" name="catagory">
            <br /><hr />
            <div id="options">
                <label for name="optionname">Option name: </label>
                <input type="text" name="option1" /><br />
                <label for name="ingredient">Ingredient: </label>
                <input type="text" name="ingredient1" />

            </div>
            <input type="button" id="addnewingredient" value="Add Another Ingredient">
            <hr />
            <input type="button" id="addnewoption" value="Add Another Option">
            <hr />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </div>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
<script type="text/javascript" charset="utf-8">
    init();
</script>