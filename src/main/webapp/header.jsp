<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">DrugStore App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="medicaments.jsp">Medicaments</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="categories.jsp">Categoies</a>
            </li>
        </ul>
        <% 
        HttpSession sessionObj = request.getSession(false);
        boolean loggedIn = (sessionObj != null && sessionObj.getAttribute("user") != null);
        if (loggedIn) { %>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="logout.do">Logout</a>
                </li>
            </ul>
        <% } else { %>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="login.do">Logout</a>
                </li>
            </ul>
        <% } %>
    </div>
</nav>
