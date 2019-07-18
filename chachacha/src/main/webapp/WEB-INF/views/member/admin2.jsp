<%@ page import="c.h.a.domain.Member"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드</title>
<jsp:include page="../header.jsp" />
<style>

h1 {
    margin-left: 15px;
    margin-bottom: 20px;
}

@media (min-width: 768px) {

    .brand-pills > li > a {
        border-top-right-radius: 0px;
    	border-bottom-right-radius: 0px;
    }
    
    li.brand-nav.active a:after{
    	content: " ";
    	display: block;
    	width: 0;
    	height: 0;
    	border-top: 20px solid transparent;
    	border-bottom: 20px solid transparent;
    	border-left: 9px solid #428bca;
    	position: absolute;
    	top: 50%;
    	margin-top: -20px;
    	left: 100%;
    	z-index: 2;
    }
}


.center-block {
	display: flex;
	justify-content: center; /* 가운데 정렬 */
}

select.form-control {
	width: auto;
	margin-bottom: 2em;
	display: inline-block
}

.rows {
	text-align: right;
}

td {
	text-align: center;
}

html, body {
  height: 100%;
}

.wrap {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.button {
  width: 140px;
  height: 45px;
  font-family: 'Roboto', sans-serif;
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  dysplay: inline-block;
  }

.button:hover {
  background-color: #2EE59D;
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>



<div class="container1">
	<div class="row">
	<br>
	
	<br>
	<br>
        <div role="tabpanel">
            <div class="col-sm-3">
                <ul class="nav nav-pills brand-pills nav-stacked" role="tablist">
                    <li role="presentation" class="brand-nav"><a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">Lorem ipsum</a></li>
                    <li role="presentation" class="brand-nav"><a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">Zombie ipsum</a></li>
                    <li role="presentation" class="brand-nav"><a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">Gansta ipsum</a></li>
                    <li role="presentation" class="brand-nav"><a href="#tab4" aria-controls="tab4" role="tab" data-toggle="tab">Corporate ipsum</a></li>
                </ul>
            </div>
            <div class="col-sm-9">
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="tab1">
                        
                        
                        
                        
                        
                     <div class="container">
	<form action="search.net">

	<br>
	<br>
	<br>
	
		<div class="input-group">
			<select id="viewcount" name="search_field">
				<option value="0" selected>아이디</option>
				<option value="1">이름</option>
				<option value="2">등급</option>
			</select> <input name="search_word" type="text" class="form-control"
				placeholder="Search">
			<button class="btn btn-primary" type="submit">검색</button>
		</div>
	</form>
<br>

<div class="container">
  <div class="wrap">
    <a href="member_grade.net?grade=판매자"><button class="button">판매자</button></a>&nbsp;&nbsp;
    <a href="member_grade.net?grade=구매자"><button class="button">구매자</button></a>&nbsp;&nbsp;
    <a href="admin.net"><button class="button">전체</button></a>
  </div>
</div>


<div class="pull-right">
	 <!--  <div class="btn-group">
		<a href="member_grade.net?grade=판매자"><button type="button" class="btn btn-success btn-filter" data-target="pagado">판매자</button></a>
		<a href="member_grade.net?grade=구매자"><button type="button" class="btn btn-warning btn-filter" data-target="pendiente">구매자</button></a>
	    <a href="admin.net"><button type="button" class="btn btn-danger btn-filter" data-target="cancelado">전체</button></a>
	  </div> -->
	</div>
<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<td colspan=6>회원목록</td>
			</tr>
			<tr >
				<th width="16%"><div>아이디</div></th>
				<th width="16%"><div>비밀번호</div></th>
				<th width="16%"><div>이름</div></th>
				<th width="16%"><div>이메일</div></th>
				<th width="16%"><div>등급</div></th>
				<th width="16%"><div>삭제</div></th>

			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Member> arr = (ArrayList<Member>) request.getAttribute("memberlist");
				for (Member m : arr) {
			%>
			<tr>
			
				<th width="16%"><div>
						<%=m.getId()%>					
				</div></th>
				
				<th width="16%"><div>
						<%=m.getPassword()%>					
				</div></th>

				<th width="16%"><div>
						<%=m.getName()%>
				</div></th>
				
				<th width="16%"><div>
						<%=m.getEmail()%>
				</div></th>
			 	<th width="16%"><div>
					<%=m.getGrade()%>
				</div></th> 
				
				<th width="16%"><div>
						<a href="member_delete.net?id=<%=m.getId()%>">삭제</a>
				</div></th>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
                        
                        
                        
                        
                        
                        
                        
                        
                    </div>
                    <div role="tabpanel" class="tab-pane" id="tab2">
                        <p>
                            Zombie ipsum reversus ab viral inferno, nam rick grimes malum cerebro. De carne lumbering animata corpora quaeritis. 
                            Summus brains sit, morbo vel maleficia? De apocalypsi gorger omero undead survivor dictum mauris.
                            Hi mindless mortuis soulless creaturas, imo evil stalking monstra adventus resi dentevil vultus comedat cerebella viventium.
                            Qui animated corpse, cricket bat max brucks terribilem incessu zomby. 
                        </p>
                        <p>
                            The voodoo sacerdos flesh eater, suscitat mortuos comedere 
                            carnem virus. Zonbi tattered for solum oculi eorum defunctis go lum cerebro. Nescio brains an Undead zombies. 
                            Sicut malus putrid voodoo horror. Nigh tofth eliv ingdead.
                        </p>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="tab3">
                        <p>
                            Lorem ipsizzle dolor away amizzle, consectetuer pizzle elizzle. Nullizzle yo velizzle, check it out volutpizzle, quis, gravida vel, yo.
                            Ma nizzle eget tortor. Sizzle eros. My shizz izzle dolizzle gizzle turpis tempizzle fo shizzle mah nizzle fo rizzle, mah home g-dizzle.
                            Maurizzle pellentesque nibh izzle own yo'. Check it out in tortor. Pellentesque fizzle rhoncizzle nisi. 
                        </p>
                        <p>
                            In hac habitasse platea dictumst. Shizzlin dizzle dapibus. You son of a bizzle tellizzle urna, pretizzle fo shizzle mah nizzle fo rizzle, mah home g-dizzle,
                            ghetto ac, check it out vitae, nunc. Shizzlin dizzle suscipizzle. Integizzle sempizzle velit sizzle dizzle.
                        </p>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="tab4">
                        <p>
                            Collaboratively administrate empowered markets via plug-and-play networks. 
                            Dynamically procrastinate B2C users after installed base benefits. Dramatically visualize customer directed convergence without 
                            revolutionary ROI.
                        </p>
                        <p>
                            Efficiently unleash cross-media information without cross-media value. 
                            Quickly maximize timely deliverables for real-time schemas. Dramatically maintain clicks-and-mortar 
                            solutions without functional solutions.
                        </p>
                        <p>
                            Completely synergize resource sucking relationships via premier niche markets. Professionally cultivate 
                            one-to-one customer service with robust ideas. Dynamically innovate resource-leveling customer service 
                            for state of the art customer service.
                        </p>
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>

<div>
	<input type="button" value="이전 페이지로 이동" onclick="history.back();">
</div>

</body>
</html>