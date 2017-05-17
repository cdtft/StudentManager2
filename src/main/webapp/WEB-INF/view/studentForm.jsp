<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Tables - Ace Admin</title>

    <meta name="description" content="Static &amp; Dynamic Tables"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.min.css"
          class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>

    <![endif]-->
</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.html" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    学生管理系统
                </small>
            </a>
        </div>
    </div><!-- /.navbar-container -->
</div>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.loadState('main-container')
        } catch (e) {
        }
    </script>

    <div id="sidebar" class="sidebar responsive ace-save-state">
        <script type="text/javascript">
            try {
                ace.settings.loadState('sidebar')
            } catch (e) {
            }
        </script>

        <%--侧边栏开始--%>
        <ul class="nav nav-list">
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">课程管理</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="${pageContext.request.contextPath}/subject/toSubjectForm/0">
                            <i class="menu-icon fa fa-caret-right"></i>
                            课程信息
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>

            <!-- 学生信息管理栏, class="active open"本页三角符号打开状态 -->
            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 学生信息管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>
                <ul class="submenu">
                    <%--class="active"控制三角标--%>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/student/form">
                            <i class="menu-icon fa fa-caret-right"></i>
                            学生信息列表
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
                <ul class="submenu">
                    <%--class="active"控制三角标--%>
                    <li class="">
                        <a href="${pageContext.request.contextPath}/student/toAddStudent">
                            <i class="menu-icon fa fa-caret-right"></i>
                            录入学生信息
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>


            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 班级管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${pageContext.request.contextPath}/grade/toGradeForm/0">
                            <i class="menu-icon fa fa-caret-right"></i>
                            班级信息
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>
        </ul><!-- /.nav-list end -->
        <%--侧边栏结束--%>
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
               data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>

                    <li>
                        <a href="#">学生信息管理</a>
                    </li>
                    <li class="active">学生信息列表</li>
                </ul><!-- /.breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->
            </div>

            <div class="page-content">
                <div class="page-header">
                    <h1>
                        学生信息管理
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            学生列表
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <!-- 表单开始 -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table  table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace"/>
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th class="detail-col">详细</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th class="hidden-480">出生日期</th>
                                        <th>选课</th>
                                        <th>录入分数</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${studentFormVo.list}" var="s">
                                    <tr>
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace"/>
                                                <span class="lbl"></span>
                                            </label>
                                        </td>

                                        <!-- 详细 -->
                                        <td class="center">
                                            <div class="action-buttons">
                                                <a href="#" class="green bigger-140 show-details-btn"
                                                   title="Show Details">
                                                    <i class="ace-icon fa fa-angle-double-down"></i>
                                                    <span class="sr-only">Details</span>
                                                </a>
                                            </div>
                                        </td>

                                        <!-- 姓名 -->
                                        <td>
                                            <a href="#">${s.name}</a>
                                        </td>
                                        <!-- 性别 -->
                                        <td>${s.gender}</td>
                                        <!-- 出生日期 -->
                                        <td><fmt:formatDate value='${s.birthday}' pattern='dd/MM/yyyy'/></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/student/toSubjectSelect/${s.id}" data-toggle="modal">选课</a>
                                        </td>
                                        <%--<div id="selectSubject" class="modal fade selectForm" tabindex="-1" style="">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-hidden="true">×
                                                        </button>

                                                    </div>

                                                    <div class="modal-header">添加课程名称</div>

                                                    <div class="modal-body">
                                                            &lt;%&ndash;选课&ndash;%&gt;
                                                        <form class="form-horizontal" role="form" id="${s.id}_selectSubject"
                                                              action="${pageContext.request.contextPath}/student/selectSubject">

                                                            <input type="hidden" name="id" value="${s.id}">
                                                            <input type="hidden" name="gradeName" value="">

                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label no-padding-right"
                                                                > 课程名 </label>

                                                                <select class="col-xs-10 col-sm-5" id="${s.id}_subject"  data-placeholder="Choose a grade" name="name">
                                                                    <c:forEach items="${subjectList}" var="subject">
                                                                        <option value="${subject.name}">${subject.name}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </form>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button class="btn btn-sm btn-danger pull-right"
                                                                data-dismiss="modal">
                                                            关闭
                                                        </button>
                                                        <button class="btn btn-sm btn-grey pull-right button_selectSubject">
                                                                &lt;%&ndash;i class="ace-icon fa fa-times"></i>&ndash;%&gt;
                                                            确定
                                                                &lt;%&ndash; $(this).parents(".modal").find(".modal-body form").get(0).submit();&ndash;%&gt;
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>--%>

                                        <%--成绩单--%>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/student/toSoreForm/${s.id}" >成绩单</a>
                                        </td>

                                            <%--删除修改操作--%>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group">
                                                    <%--修改按钮--%>
                                                <a href="#${s.id}_togger" role="button"
                                                   class="bigger-125 bg-primary white btn btn-xs btn-info"
                                                   data-toggle="modal">
                                                    <i class="ace-icon fa fa-pencil bigger-120 bigger-125 bg-primary white"></i>
                                                </a>
                                                    <%--修改的弹出框--%>
                                                <div id="${s.id}_togger" class="modal fade" tabindex="-1" style="">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal"
                                                                        aria-hidden="true">×
                                                                </button>

                                                            </div>

                                                            <div class="modal-header">
                                                                <span class="text-center">修改学生信息</span>
                                                            </div>

                                                            <div class="modal-body">
                                                                    <%--添加表单--%>
                                                                <form class="form-horizontal" role="form" id="${s.id}"
                                                                      action="${pageContext.request.contextPath}/student/save">

                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right"
                                                                               for="id"> 学号 </label>

                                                                        <div class="col-sm-9">
                                                                            <input type="text" id="id" name="id"
                                                                                   placeholder="id"
                                                                                   class="col-xs-10 col-sm-5"
                                                                                   value="${s.id}"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right"
                                                                               for="name"> 姓名 </label>

                                                                        <div class="col-sm-9">
                                                                            <input type="text" id="name" name="name"
                                                                                   placeholder="name"
                                                                                   class="col-xs-10 col-sm-5"
                                                                                   value="${s.name}"/>
                                                                        </div>
                                                                    </div>
                                                                        <%--年级名称--%>
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right">
                                                                            年级 </label>
                                                                        <div class="col-sm-9">
                                                                            <select class="col-xs-10 col-sm-5"
                                                                                    data-placeholder="Choose a grade"
                                                                                    >
                                                                                <c:forEach items="${gradeList}"
                                                                                           var="grade">
                                                                                    <option value="${grade.name}">${grade.name}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right"
                                                                               for="gender"> 性别 </label>

                                                                        <div class="col-sm-9">
                                                                            <input type="text" id="gender" name="gender"
                                                                                   placeholder="gender"
                                                                                   class="col-xs-10 col-sm-5"
                                                                                   value="${s.gender}"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right"
                                                                               for="birthday"> 出生日期 </label>

                                                                        <div class="col-sm-9">
                                                                            <input type="text" id="birthday"
                                                                                   name="birthday"
                                                                                   placeholder="birthday"
                                                                                   class="col-xs-10 col-sm-5 birthday"
                                                                                   readonly="readonly"
                                                                                   value="<fmt:formatDate value='${s.birthday}' pattern='dd/MM/yyyy'/>"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label no-padding-right"
                                                                               for="addr"> 家庭住址 </label>

                                                                        <div class="col-sm-9">
                                                                            <input type="text" id="addr" name="addr"
                                                                                   placeholder="addr"
                                                                                   class="col-xs-10 col-sm-5"
                                                                                   value="${s.addr}"/>
                                                                        </div>
                                                                    </div>
                                                                </form>

                                                            </div>

                                                            <div class="modal-footer">
                                                                <button class="btn btn-sm btn-danger pull-right"
                                                                        data-dismiss="modal">
                                                                    关闭
                                                                </button>
                                                                <button class="btn btn-sm btn-grey pull-right button_submit">
                                                                        <%--i class="ace-icon fa fa-times"></i>--%>
                                                                    确定
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                &nbsp;
                                                    <%--删除按钮--%>
                                                <a href="#my-modal-delete" onclick="showmodel(${s.id})" role="button"
                                                   class="bigger-125 bg-primary white btn btn-xs btn-danger"
                                                   data-toggle="modal">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </a>

                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                <div class="inline pos-rel">
                                                    <button class="btn btn-minier btn-primary dropdown-toggle"
                                                            data-toggle="dropdown" data-position="auto">
                                                        <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                                    </button>

                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                        <li>
                                                            <a href="#" class="tooltip-info" data-rel="tooltip"
                                                               title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#" class="tooltip-success" data-rel="tooltip"
                                                               title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                                            </a>
                                                        </li>

                                                        <li>
                                                            <a href="#" class="tooltip-error" data-rel="tooltip"
                                                               title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- 详细信息表 -->
                                    <tr class="detail-row">
                                        <td colspan="8">
                                            <div class="table-detail">
                                                <div class="row">
                                                    <div class="col-xs-12 col-sm-2">
                                                        <div class="text-center">
                                                                <%--上传的头像地址--%>
                                                            <img height="150" class="thumbnail inline no-margin-bottom"
                                                                 alt="Domain Owner's Avatar"
                                                                 src="${pageContext.request.contextPath}/upload/${s.id}.png"/>
                                                            <br/>
                                                            <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                                                <div class="inline position-relative">
                                                                    <a class="user-title-label" href="#">
                                                                        <i class="ace-icon fa fa-circle light-green"></i>
                                                                        &nbsp;
                                                                        <span class="white">${s.name}</span>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="col-xs-12 col-sm-7">
                                                        <div class="space visible-xs"></div>

                                                        <div class="profile-user-info profile-user-info-striped">
                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 姓名</div>

                                                                <div class="profile-info-value">
                                                                    <span>${s.name}</span>
                                                                </div>
                                                            </div>

                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 班级</div>

                                                                <div class="profile-info-value">
                                                                    <span>${s.gradeName}</span>
                                                                </div>
                                                            </div>

                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 学号</div>

                                                                <div class="profile-info-value">
                                                                    <span>${s.id}</span>
                                                                </div>
                                                            </div>

                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 家庭住址</div>

                                                                <div class="profile-info-value">
                                                                    <i class="fa fa-map-marker light-orange bigger-110"></i>
                                                                    <span>${s.addr}</span>
                                                                </div>
                                                            </div>


                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 年龄</div>

                                                                <div class="profile-info-value">
                                                                    <span>${s.age}</span>
                                                                </div>
                                                            </div>

                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 所选课程</div>

                                                                <div class="profile-info-value">
                                                                    <c:forEach items="${s.subjectList}" var="subject">
                                                                        <span>${subject}</span>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>

                                                            <div class="profile-info-row">
                                                                <div class="profile-info-name"> 总成绩</div>
                                                                <div class="profile-info-value">
                                                                    <span>${s.totalScore}</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <form action="${pageContext.request.contextPath}/student/upload"
                                                          enctype="multipart/form-data" method="post">
                                                        <input type="hidden" name="id" value="${s.id}">
                                                        <input type="file" name="file">
                                                        <input type="submit">
                                                    </form>

                                                    <%--<div class="col-xs-12 col-sm-3">
                                                        <div class="space visible-xs"></div>
                                                        <h4 class="header blue lighter less-margin">上传图片</h4>

                                                        <div class="space-6"></div>

                                                        <form action="${pageContext.request.contextPath}/student/upload" class="uploadForm" method="post" enctype="multipart/form-data">
                                                            <input type="hidden" name="id" value="${s.id}">
                                                            <input type="file" name="file">

                                                            <div class="clearfix">

                                                                <button class="pull-right btn btn-sm btn-primary btn-white btn-round uploadFile" type="button">
                                                                    Submit
                                                                    <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>--%>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </c:forEach>

                                    <%--删除按钮弹出框--%>
                                    <div id="my-modal-delete" class="modal fade " tabindex="-1" style="">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-hidden="true">×
                                                    </button>
                                                </div>
                                                <%--获取id的值--%>
                                                <input type="hidden" id="studentId">


                                                <div class="modal-body">
                                                    确认删除
                                                </div>

                                                <div class="modal-footer">
                                                    <button class="btn btn-sm btn-danger pull-right"
                                                            data-dismiss="modal">
                                                        关闭
                                                    </button>

                                                    <button class="btn btn-sm btn-grey pull-right"
                                                            data-dismiss="modal" id="deleteStudent">
                                                        确认
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </table>
                                <%--分页列表--%>
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="dataTables_info" id="dynamic-table_info" role="status"
                                             aria-live="polite">
                                            Showing 1 to 10 of 23 entries
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="dataTables_paginate paging_simple_numbers"
                                             id="dynamic-table_paginate">
                                            <ul class="pagination">
                                                <c:forEach begin="${1}" end="${studentFormVo.totalPage}" var="pageNum">
                                                    <li class="paginate_button active" aria-controls="dynamic-table"
                                                        tabindex="0">
                                                        <a href="${pageContext.request.contextPath}/student/pageSkip/${pageNum-1}">${pageNum}</a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                            </div><!-- /.span -->
                        </div><!-- /.row -->

                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Wang</span>
							Application &copy; 2017-?
						</span>

                &nbsp; &nbsp;
                <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
            </div>
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/buttons.colVis.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.select.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/grid.locale-en.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {
        //initiate dataTables plugin


        ////

        setTimeout(function () {
            $($('.tableTools-container')).find('a.dt-button').each(function () {
                var div = $(this).find(' > div').first();
                if (div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
                else $(this).tooltip({container: 'body', title: $(this).text()});
            });
        }, 500);

        //And for the first simple table, which doesn't have TableTools or dataTables
        //select/deselect all rows according to table header checkbox
        var active_class = 'active';
        $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $(this).closest('table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
            });
        });
        //select/deselect a row when the checkbox is checked/unchecked
        $('#simple-table').on('click', 'td input[type=checkbox]', function () {
            var $row = $(this).closest('tr');
            if ($row.is('.detail-row ')) return;
            if (this.checked) $row.addClass(active_class);
            else $row.removeClass(active_class);
        });
        /********************************/
        //add tooltip for small view action buttons in dropdown menu
        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        //tooltip placement on right or left
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }

        /***************/
        $('.show-details-btn').on('click', function (e) {
            e.preventDefault();
            $(this).closest('tr').next().toggleClass('open');
            $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
        })


        $('.button_submit').on('click', function () {

            $(this).parents(".modal").find(".modal-body form").get(0).submit();
        })

        $('.button_selectSubject').on('click', function () {
            //$(this).parents(".selectForm").find(".modal-body form").get(0).submit();
            $(this).parents().parents().find(".selectForm form").submit();
        })

        $('#deleteStudent').on('click', function () {
            var id = $('#studentId').val();
            $.get("${pageContext.request.contextPath}/student/delete", {id: id});
            window.location.replace("${pageContext.request.contextPath}/grade/toGradeForm/0");
        })

        $('.birthday').datepicker({
            dateFormat: "yy-MM-dd"
        });

        $('.uploadFile').on('click', function () {
            $(this).parents().parents('.uploadForm').get(0).submit();
        })

    })

    function showmodel(id) {
        $('#studentId').val(id);
    }
</script>
</body>
</html>
