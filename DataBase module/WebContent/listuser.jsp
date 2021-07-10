<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="include/header.jsp"><c:param name="title" value="List User Page"/></c:import>
<c:import url="include/head.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="org.renu.entity.User" %>
<div class="wrapper">
   <div class="section section-signup" style="background-image: linear-gradient(to top, #000000, #353434, #696666, #a29e9d, #ded9d7); background-size: cover; background-position: top center; min-height: 700px;">
            <div class="container" style="margin-top: -85px">
                <br/>
                <br/>

             <div>
                    <div class="container text-center">
                        <div class="row justify-content-md-center">
                            <div class="col-md-12 col-lg-12">
                                 <br>
                                <h1 style="font-family: Arial "><b>List user</b></h1>
                               </div>
                        </div>
                        
                  <strong>listing users  </strong>
       <hr/>
       <table border="1">
       <thead>
       <th>User ID</th>
       <th>User name</th>
       <th>Email</th>
       <th>Operation</th>
       </thead>
        
        <c:forEach items="${listUser}" var="user" >
        <c:url var="updateURL" value="Operation">
        <c:param name="page" value="updateUser"></c:param>
        <c:param name="userId" value="${user.user_id }"></c:param>
        
        
        <c:param name="userName" value="${user.user_name }"></c:param>
        
        <c:param name="email" value="${user.email }"></c:param>
        </c:url>

        <c:url var="deleteUser" value="Operation">
        <c:param name="page" value="deleteUser"></c:param>
        <c:param name="userId" value="${user.user_id }"></c:param>
        </c:url>
       
       <tr>
       <td>${user.user_id }</td>
       <td>${user.user_name }</td>
       <td>${user.email}</td>
       <td>
       <a href="${updateURL }">Update|</a>
       <a href="${deleteUser}"
       onclick="if(!confirm('Are you sure to delete the user ?')) return false ">Delete</a>
       
       </td>
       </tr>
        </c:forEach>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       <%!// String deleteURL; %>
       <% 
       
      
       
      
      //List<User> listUser=(List)request.getAttribute("listUser");
      /** String updateURL;
       
       for(int i=0;i<listUser.size();i++)
       {
    	   out.print("<tr>");
    	   out.print("<td>"+ listUser.get(i).getUser_id()+"</td>");
    	   out.print("<td>"+ listUser.get(i).getUser_name()+"</td>");
    	   out.print("<td>"+ listUser.get(i).getEmail()+"</td>");
    	  updateURL=request.getContextPath()+"/Operation?page=updateUser" +
    	             "&userId="+listUser.get(i).getUser_id()+
    	              "&userName="+listUser.get(i).getUser_name() +
    	             "&email="+listUser.get(i).getEmail();
    	  deleteURL=request.getContextPath()+"/Operation?page=deleteUser" +
    		    	 "&userId="+listUser.get(i).getUser_id();
    		    	  
    	  
    	   out.print("<td><a href="+updateURL+">Update</a>|"); **/
    	   

    	  
       %>
       
       <!-- java script here -->
     <!-- above href link is here due to error i have to remove that-->
           <!--  onclick="if(!confirm('Are you sure to delete the user ?')) return false ">Delete</a>  -->
           <!--  </td></tr>-->
        <% 
       // }
       %>
       </table>
                   </div>
           </div>
       </div>
   </div>
    </div>
    
<c:import url="include/footer.jsp"/>

