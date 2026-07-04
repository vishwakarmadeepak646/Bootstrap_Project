<%@page import="com.sunilos.p4.util.MessageSource"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.bean.UserBean"%>
<%@page import="com.sunilos.p4.bean.RoleBean"%>

<%
UserBean currentUser = (UserBean) session.getAttribute("user");
boolean loggedIn = currentUser != null;
boolean isStudent = loggedIn && currentUser.getRoleId() == RoleBean.STUDENT;
boolean isAdmin = loggedIn && currentUser.getRoleId() == RoleBean.ADMIN;
String firstName = loggedIn ? currentUser.getFirstName() : "Guest";
%>

<%
MessageSource ms = MessageSource.getInstance();
%>

<div class="container-fluid px-4 py-4" style="max-width: 1100px;">

	<!-- ===== Hero Banner ===== -->
	<div
		class="rounded-4 text-white p-4 p-md-5 mb-4 d-flex align-items-center gap-4 shadow"
		style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
		<div
			class="flex-shrink-0 rounded-circle d-flex align-items-center justify-content-center"
			style="width: 80px; height: 80px; background: rgba(255, 255, 255, 0.15); border: 2px solid rgba(255, 255, 255, 0.25); font-size: 2.3rem;">
			<i class="bi bi-mortarboard-fill"></i>
		</div>
		<div>
			<h1 class="fw-bold mb-1 fs-2">
				<%=ms.get("welcome.title")%><%
			if (loggedIn) {
			%>,
				<%=firstName%>!<%
			} else {
			%>
				<%=ms.get("welcome.ElseTitle") %><%
			}
			%>
			</h1>
			<p class="mb-0 opacity-75"><%= ms.get("welcome.tagline") %></p>
		</div>
	</div>

	<!-- ===== Section label ===== -->
	<p class="text-uppercase text-muted fw-semibold small mb-3"
		style="letter-spacing: .08em;">
		<%
		if (isAdmin) {
		%><%= ms.get("welcome.adm") %>
		<%
		} else if (isStudent) {
		%>Quick Access
		<%
		} else {
		%><%= ms.get("welcome.start")%><%
		}
		%>
	</p>

	<!-- ===== Dashboard Cards ===== -->
	<div class="row g-3">

		<%
		if (isStudent) {
		%>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.GET_MARKSHEET_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-primary">
					<div class="fs-1 text-primary mb-2">
						<i class="bi bi-file-earmark-text-fill"></i>
					</div>
					<h6 class="fw-bold mb-1">My Marksheet</h6>
					<p class="text-muted small mb-0">View your academic results</p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.MY_PROFILE_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-success">
					<div class="fs-1 text-success mb-2">
						<i class="bi bi-person-circle"></i>
					</div>
					<h6 class="fw-bold mb-1">My Profile</h6>
					<p class="text-muted small mb-0">View and edit your details</p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.CHANGE_PASSWORD_CTL%>"
				class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-warning">
					<div class="fs-1 text-warning mb-2">
						<i class="bi bi-key-fill"></i>
					</div>
					<h6 class="fw-bold mb-1">Change Password</h6>
					<p class="text-muted small mb-0">Update your login password</p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>"
				class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-danger">
					<div class="fs-1 text-danger mb-2">
						<i class="bi bi-trophy-fill"></i>
					</div>
					<h6 class="fw-bold mb-1">Merit List</h6>
					<p class="text-muted small mb-0">View class rankings</p>
				</div>
			</a>
		</div>

		<%
		} else if (isAdmin) {
		%>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.USER_LIST_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-primary">
					<div class="fs-1 text-primary mb-2">
						<i class="bi bi-people-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.user") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.userLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.COLLEGE_LIST_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-success">
					<div class="fs-1 text-success mb-2">
						<i class="bi bi-bank2"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.college") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.collegeLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.STUDENT_LIST_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card  border-top border-4 border-black">
					<div class="fs-1 mb-2" style="color: black;">
						<i class="bi bi-mortarboard-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.students") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.studentsLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.MARKSHEET_LIST_CTL%>"
				class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-warning">
					<div class="fs-1 text-warning mb-2">
						<i class="bi bi-file-earmark-text-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.Marksheets") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.MarksheetsLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.ROLE_LIST_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-danger">
					<div class="fs-1 text-danger mb-2">
						<i class="bi bi-shield-fill-check"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.roles") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.rolesLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>"
				class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card  border-top border-4 border-success"
					style="border-top: 4px solid #0d9488;">
					<div class="fs-1 mb-2" style="color: #0d9488;">
						<i class="bi bi-trophy-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"> <%= ms.get("welcome.merit") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.meritLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.GET_MARKSHEET_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-primary">
					<div class="fs-1 text-primary mb-2">
						<i class="bi bi-search"></i>
					</div>
					<h6 class="fw-bold mb-1"><%= ms.get("welcome.getMark") %></h6>
					<p class="text-muted small mb-0"> <%= ms.get("welcome.getMarkLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.MY_PROFILE_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-secondary">
					<div class="fs-1 mb-2" style="color: #374151;">
						<i class="bi bi-person-gear"></i>
					</div>
					<h6 class="fw-bold mb-1"> <%= ms.get("welcome.profile") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.profileLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.FACULTY_LIST_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-info"
					style="border-top: 4px solid #0891b2;">
					<div class="fs-1 mb-2" style="color: #0891b2;">
						<i class="bi bi-person-badge-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"> <%= ms.get("welcome.faculty") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.facultyLine") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.PRODUCT_LIST_CTL %>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-info">
					<div class="fs-1 mb-2" style="color: #0891b2;">
						<i class="bi bi-cart"></i>
					</div>
					<h6 class="fw-bold mb-1"> <%= ms.get("welcome.product") %></h6>
					<p class="text-muted small mb-0"> <%= ms.get("welcome.productLine") %></p>
				</div>
			</a>
		</div>

		<%
		} else {
		%>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.LOGIN_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-primary">
					<div class="fs-1 text-primary mb-2">
						<i class="bi bi-box-arrow-in-right"></i>
					</div>
					<h6 class="fw-bold mb-1"><%=ms.get("welcome.login") %></h6>
					<p class="text-muted small mb-0"><%= ms.get("welcome.signUp") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.USER_REGISTRATION_CTL%>"
				class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-success">
					<div class="fs-1 text-success mb-2">
						<i class="bi bi-person-plus-fill"></i>
					</div>
					<h6 class="fw-bold mb-1"><%=ms.get("welcome.register") %></h6>
					<p class="text-muted small mb-0"><%=ms.get("welcome.ac") %></p>
				</div>
			</a>
		</div>

		<div class="col-6 col-md-4 col-lg-3">
			<a href="<%=ORSView.GET_MARKSHEET_CTL%>" class="text-decoration-none">
				<div
					class="card h-100 border-0 shadow-sm rounded-4 text-center p-3 ors-card border-top border-4 border-info"
					style="border-top: 4px solid #7c3aed;">
					<div class="fs-1 mb-2" style="color: #7c3aed;">
						<i class="bi bi-search"></i>
					</div>
					<h6 class="fw-bold mb-1"><%=ms.get("welcome.marksheet") %></h6>
					<p class="text-muted small mb-0"><%=ms.get("welcome.search") %></p>
				</div>
			</a>
		</div>

		<%
		}
		%>

	</div>
	<!-- /row -->
</div>