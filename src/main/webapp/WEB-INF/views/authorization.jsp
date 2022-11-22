<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@include file="./header.jsp"%>

<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">
					<center>
						<form action="/web/account" method = "post">
							<table border="0">
								<tr>
									<td width="100">Login</td>
									<td><input type="text" name="login" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="password" /></td>
								</tr>
								<tr>
									<td align="center" colspan="2"><input type="submit"
										value="Send" /></td>
								</tr>
							</table>
						</form>
					</center>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="./footer.jsp"%>