
<!-- Navbar -->
<title>${param.title}</title>
<nav class="navbar navbar-expand-lg fixed-top" style="background-image: linear-gradient(to right top, #e0c11c, #e89f0d, #ea7c1b, #e5582c, #d82f3c);">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/Site?page=home"" rel="tooltip" title="Renu Kushwah" data-placement="bottom" target="_blank">
                <img src="assets/img/logo.png" alt=“logo of lispedia”>
            </a>
            <button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse justify-content-center" id="navigation">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Site?page=home" onclick="scrollToDownload()">
                        <i class="fa fa-home"></i>
                        <p><b>Home</b></p>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Operation?page=listuser" onclick="scrollToDownload()">
                        <i class="now-ui-icons files_paper"></i>
                        <p><b>Listuser</b></p>
                    </a>
                    </li>
                  
                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Operation?page=adduser" onclick="scrollToDownload()">
                        <i class="now-ui-icons files_paper"></i>
                        <p><b>Adduser</b></p>
                    </a>
                    </li>  
            
            </ul>
        </div>
    </div>
</nav>
<!-- End Navbar -->