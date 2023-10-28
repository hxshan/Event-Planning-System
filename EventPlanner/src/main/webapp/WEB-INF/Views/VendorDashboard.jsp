<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/DashStyle.css">
    <link rel="stylesheet" href="css/Navs-Modals.css">
    <title>Dashboard</title>
</head>
<body>
    <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
        <form action="./PageRedirectController" >
        <input type="hidden" name="page" value="AddService"/>
        
        <button name="button" value="AddService" id="addServiceBtn" class="addEventBtn-desk" >
                <img src="Plus.png" alt="Add service">
                <p>Add Service
                </p>             
            </button>
            <button name="button" value="AddService" id="addServiceBtn" class="addEventBtn-mob" >
                <img src="Plus.png" alt="Add service">
            </button>
        
        </form>
                        <div class="user-pfp-img">
                <form action="" method="get">
                    <input type="hidden" name="page" value="org-profile">
                    <button class="user-pfp-img-btn" type="submit">
                        <img src="MaleUser.png" alt="pfp">
                    </button>
                </form>                      
            </div> 
        </div>
    </header>
    <main>
        <div class="nav-background" id="nav-background">       
            <div class="nav-bar slideRight" id="nav-bar">
                <button type="button" class="nav-close" id="nav-close" onclick="closeNavbar()">
                    <img src="Multiply.png" alt="Close">
                </button>

                <div class="nav-item" id="Dashboard">
                    <button class="nav-link">
                        Dashboard
                    </button>
                </div>
                <div class="nav-item" id="AllEvents">
                    <button class="nav-link">
                        All Services 
                    </button>
                </div>
                <div class="nav-item" id="Something">
                    <button class="nav-link">
                        Orders
                    </button>
                </div>
            </div>
        </div>

        <%@ include file="VendorNavbarMenus.jsp" %>
        
        
        <div class="Dashboard-content">
            <div class="recentEvents-con" id="recentEvents-con">
                <h2 class="dashboard-title">Upcoming orders</h2>
                <!--<div class="event-empty">
                    <img src="no-event.png" alt="">
                </div>-->
                <div class="event">
                    <h3>Order name</h3>
                    <div class="event-bottom">
                        <div class="eventType">
                            <img class="Event-icons" src="Event-star.png" alt="">
                            <p>Birthday Party</p> 
                        </div>
                        <div class="event-startdate">
                            <img class="Event-icons" src="Time.png" alt="">
                            <p>2023/10/25</p> 
                        </div>
                    </div>
                    <div class="event-btns-con">
                        <form action="" method="post">
                            <input type="hidden" name="" value="">
                            <button class="event-buttons" type="submit">
                                <img src="view more btn.png" alt="">
                            </button>
                        </form>
                        <form action="" method="post">
                            <input type="hidden" name="" value="">
                            <button class="event-buttons" id="delete-btn" type="submit">
                                <img src="Delete btn.png" alt="">
                            </button>
                        </form>
                    </div>
                </div>
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
    <script src="NavigationModals.js"></script>
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
