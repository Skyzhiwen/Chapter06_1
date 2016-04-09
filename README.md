# Chapter06_1
购物车：
Book.java 封装图书 定义了id和name属性
BookDB.java 模拟保存数据库的方法，通过map实现 
ListBookServlet.java 显示可购买的书
PurchaseServlet.java 该类实现了两个功能，一个是将用户购买的图书信息保存在Session对象中，一个是在用户购买图书之后重定向到购买图书的列表中,
在实现的时候，通过ArrayList集合模拟一个购物车，然后将购买的所有图书添加到购物车中，最后，通过Session对象传递给CartServlet,由CartServlet.
CartServlet.java:用于展示用户已经购买的图书列表。

实现用户登录：
Login.html:用户登录页面
IndexServlet.java:用于显示网站的首页，如果没有登录提示用户登录；登录了提示欢迎；在判断用户是否登录的时候，需要获取用户信息Session对象。
LoginServlet.java:用于判断用户输入的用户名和密码是否正确。
LogoutServlet.java：用于完成用户退出。这时我们需要消除Session对象中的用户信息，并跳转到网站的首页面。
