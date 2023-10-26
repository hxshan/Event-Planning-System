<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <!-- <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="assets/icons/Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
            <button name="button" value="AddEvent" id="addEventBtn" class="addEventBtn-desk" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
                <p>Add Event
                </p>             
            </button>
            <button name="button" value="AddEvent" id="addEventBtnmob" class="addEventBtn-mob" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
            </button>
            <div class="user-pfp-img">
                <form action="./PageRedirectController" method="get">
                	<input type="hidden" name="page" value="org-profile">
                    <button class="user-pfp-img-btn" type="submit">
                        <img src="assets/icons/MaleUser.png" alt="pfp">
                    </button>
                </form>                      
            </div> 
        </div>
    </header> -->
    <%@ include file="NavBar.jsp" %>
    <main>
        <%@ include file="NavMenus.jsp" %>
        
        <div class="Dashboard-content">
            <div class="recentEvents-con" id="recentEvents-con">
                <h2>Dashboard</h2>
               	<c:choose>
    				<c:when test="${empty Elist}">      
        				<div class="event-empty">
                    		<img src="assets/images/no-event.png" alt="no-event">
                		</div>
    				</c:when>
    				<c:otherwise>     
        				<c:forEach var="event" items="${Elist}">
                			<div class="event">
                    			<h3>${event.getName()}</h3>
                   			 <div class="event-bottom">
                        			<div class="eventType">
                   			        			 <img class="Event-icons" src="assets/icons/Event-star.png" alt="">
                            		
                            		<p>Some text goes here</p> 
                       			 </div>
                        			<div class="event-startdate">
                            			<img class="Event-icons" src="assets/icons/Time.png" alt="">
                            			<p>${event.getStartdate()}</p> 
                    			    </div>
                    			</div>
                 				<div class="event-btns-con">
                    			    				<form action="./EventController" method="post">
                            				<input type="hidden" name="triggerType" value="EditEvent"/>
                            				<input type="hidden" name="eventId" value="${event.getId()}"/>
                            				<input type="hidden" name="userId" value="${User.getId()}"/>
                            				<button class="event-buttons" type="submit">
                                				<img src="assets/icons/view more btn.png" alt="">
                            				</button>
                        				</form>
                        				<form action="./EventController" method="post">
                            				<input type="hidden" name="triggerType" value="DeleteEvent"/>
                            				<input type="hidden" name="eventId" value="${event.getId()}"/>
                            				<input type="hidden" name="userId" value="${User.getId()}"/>
                            				<button class="event-buttons" type="submit">
                                				<img src="assets/icons/Delete btn.png" alt="">
                           	 				</button>
                        				</form>
                    				</div>
                			</div>
                		</c:forEach>
    				</c:otherwise>
				</c:choose>

            </div>
            <div class="dashboard-bottom">
                <div class="Report-con" id="Report-con">
                    <h2 class="dashboard-title">Report</h2>
                    <div class="report">

                    </div>
                </div>
                <div class="calender" id="calender">
                    <h2 class="dashboard-title">Calender</h2>
                    <div class="calender-con">
        
                        <div class="calender-header">
                            <p class="cal-title" id="month"></p>
                            <p class="cal-title"id="year"></p>  
                        </div>
                        
                          <table>
                            <thead>
                              <tr>
                                <th class="caleder-day">S</th>
                                <th class="caleder-day">M</th>
                                <th class="caleder-day">T</th>
                                <th class="caleder-day">W</th>
                                <th class="caleder-day">T</th>
                                <th class="caleder-day">F</th>
                                <th class="caleder-day">S</th>
                              </tr>
                            </thead>
                            <tbody id="calendar-body">
                            </tbody>
                        
                          </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
   <script src="scripts/NavigationModals.js"></script>
    <script>
      //Genarating calender
      const today = new Date()
            //console.log(today)
            const year = today.getFullYear()
            //console.log(year)
            const month = today.getMonth()
           // console.log(month)
            const firstDayOfMonth = new Date(year, month, 1)
            //console.log(firstDayOfMonth)
            const lastDayOfMonth = new Date(year, month + 1, 0)
            //console.log(lastDayOfMonth)
            const calendarBody = document.getElementById('calendar-body');

            const monthTitle= document.getElementById('month');
            const yearTitle=document.getElementById('year')
            const months=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
            monthTitle.textContent=months[month];
            yearTitle.textContent=year;



            for (let day = firstDayOfMonth; day <= lastDayOfMonth; day.setDate(day.getDate() + 1)) {
              const cell = document.createElement('td')
              cell.classList.add('round')
              cell.textContent = day.getDate()
              
              if (day.toDateString() === today.toDateString()) {
                cell.classList.add('today');
              }


              if (day.getDay() === 0) {
                const row = document.createElement('tr');
                row.appendChild(cell);
                calendarBody.appendChild(row);
              } else {
                calendarBody.lastElementChild.appendChild(cell);
              }
            }
    </script>
</body>
</html>
</body>
</html>