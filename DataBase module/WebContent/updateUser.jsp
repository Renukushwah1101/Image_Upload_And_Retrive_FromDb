<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="include/header.jsp"><c:param name="title" value="UpdateUserPage"/></c:import>
<c:import url="include/head.jsp"/>

  <div class="">
        <div class="section section-signup" style="background-image: linear-gradient(to bottom, #f6a821, #c96f33, #8b4234, #472325, #000000); background-size: cover; background-position: top center; min-height: 700px;">

            <!--  <div class="row">-->
                <!--  <div class="text-center">-->
                        <div class="row justify-content-md-center">
    
                         <div class="col-md-12 col-lg-12">
                                <h1 style="font-family: Arial"><b>Update Form</b></h1>
                            </div>
                        </div>
<div class="container mtb">
<div class="row">
<div class="col-lg-6">

  <form action="${pageContext.request.contextPath}/Operation " method ="post">
    Username:<input type="text" name="username" value="${param.userName }"required="required"/><br/>
    Email:<input type="email" name="email"value= "${param.email }" required="required"/><br/>
    <input type ="hidden" name="userId" value="${param.userId }"/>
    <input type="hidden" name="form" value="updateUserOperation"/>
    
    <input type="submit" value="Update User"/>

  </form>


</div>
</div>
</div>
</div>
</div>

<c:import url="include/footer.jsp"/>