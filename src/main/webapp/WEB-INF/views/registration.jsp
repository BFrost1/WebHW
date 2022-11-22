<%@ page isELIgnored = "false" %>
<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@include file="./header.jsp"%>
<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">
					<div class="registrationBox">
						<h2>REGISTRATION</h2>
						<form action="/web/reg" method="post">
							<label class="icon"> <i class="far fa-envelope"></i>
							</label> <input type="text" name="email" placeholder="Email" pattern="^((([0-9A-Za-z]{1}[-0-9A-z\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\.){1,2}[-A-Za-z]{2,})$" />
							<label class="icon"> <i class="fas fa-shield-alt"></i>
							</label> <input type="password" name="password" placeholder="Password" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$" />
							<label class="icon"> <i class="fas fa-shield-alt"></i>
							</label> <input type="password" name="rePassword" placeholder="Re-password" pattern="^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$" />
							<label class="icon"> <i class="fas fa-user"></i>
							</label> <input type="text" name="fullName" placeholder="Full name" required /> <label class="icon"> <i class="fas fa-map-marker-alt"></i>
							</label> <select name="region">
								<option value="Lviv">Lviv region</option>
								<option value="Kyiv">Kyiv region</option>
								<option value="Kharkiv">Kharkiv region</option>
							</select> <label class="icon"> <i class="fas fa-venus-mars"></i>
							</label> <select name="gender">
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
							<div class="comment">
								<label class="icon"><i class="far fa-comment"></i></label>
								<textarea name="comment"></textarea>
							</div>
							<div class="checkbox">
								<p>I agree to the processing of my personal data</p>
								<input type="checkbox" name="agreement" required />
							</div>
							<input type="submit" value="send" name="send" />
						</form>
						${requestScope.successful}
						${requestScope.email}
						${requestScope.password}
						${requestScope.repassword}
						${requestScope.fullname}
						${requestScope.region}
						${requestScope.gender}
						${requestScope.comment}
						${requestScope.agreement}
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="./footer.jsp"%>