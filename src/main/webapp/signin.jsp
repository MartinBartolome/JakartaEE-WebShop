<%@ include file="header.jspf" %> 
	<form action="signin" method="post">
	<fieldset>
	<legend><fmt:message key="signin"/>: </legend>
	<table>
		<tbody>
		<tr>
			<th>
				<label for="UName"><fmt:message key="UserName"/>:</label>
			</th>
			<td>
				<input 
					type="text"
					name="UName"
					id="UName"
					size="40"
					maxlength="40"
					placeholder=<fmt:message key="UserName"/>
					pattern=".{6,40}" 
					required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label for="password">
					<fmt:message key="password"/>:
				</label>
			</th>
			<td>
				<input 
					type="password" 
					name="password"
					id="password"
					size="10"
					maxlength="10"
					title="6-10 Zeichen"
					placeholder=<fmt:message key="passwordenter"/>
					pattern=".{6,10}" 
					required="required">
			</td>
		</tr>
		<tr>
			<td/>
			<td>
				<a href="?"><fmt:message key="passwordlost"/></a>
			</td>
		</tr>
		<tr>
			<td/><td>
				<input type="submit" value=<fmt:message key="login"/>>
			</td>
		</tr>
	</tbody>
	</table>
	</fieldset>
	</form>
<%@ include file="footer.jspf" %>
