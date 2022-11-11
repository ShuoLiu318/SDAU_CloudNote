//加载笔记
function loadNotes(){
	//移除上次被选中的笔记本的样式
	$("#book_list li a").removeClass("checked");
	//给选中的笔记本添加样式
	$(this).find("a").addClass("checked");
	//获取当前笔记本的id
	var noteBookId=$(this).data("noteBookId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8081/SDAU_CloudNote/note/loadnotes.do",
		type:"post",
		dataType:"json",
		data:{"noteBookId":noteBookId},
		success:function(result){
			if(result.status==0){
					
				//清空原有的笔记列表
				$("#note_list").empty();
					
				//获取笔记信息
				var notes=result.data;
			
				for(var i=0;i<notes.length;i++){//通过for循环获取每一条笔记信息
					//获取笔记标题，显示在笔记列表下面
					var noteName=notes[i].cn_note_title;
					    
					//获取笔记的id
					var noteId=notes[i].cn_note_id;
					
					//拼一个笔记列表li	
					var s_li='<li class="online">';
						s_li+="<a>";
						s_li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+noteName+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
						s_li+='</a>';
						s_li+='<div class="note_menu" tabindex="-1">';
						s_li+='<dl>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
						s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
						s_li+='</dl>';
						s_li+='</div>';
						s_li+='</li>';
						
					//将dom格式转换为jQuery格式
					var $li=$(s_li);
					
					$li.data("noteId",noteId);
					$("#note_list").append($li);//prepend()
				}
		    }
         }
    });
}

//弹出添加笔记窗口
function showAddNoteWindow(){
	$(".opacity_bg").show();//显示灰色背景
	$("#can").load("alert/alert_note.html");//弹出新建笔记本的框
}

//关闭添加笔记窗口
function closeAddNoteWindow(){
	$("#can").empty();
 	$(".opacity_bg").hide();  //隐藏灰色背景
}

//添加笔记
function addNote(){
	var noteName=$("#input_note").val();
	//检验input_note是否为空
	var flag=true;
	if(noteName==""){
		alert("请输入笔记名");
		flag=false;
	}
	
	//获取笔记本id
	var $li=$("#book_list li a.checked").parent();//a.checked表示：带有样式的元素
	var noteBookId=$li.data("noteBookId");
	//发送ajax请求   
	if(flag){
		$.ajax({
			url:"http://localhost:8081/SDAU_CloudNote/note/addnote.do",
			type:"post",
			data:{"noteTitle":noteName,"noteBookId":noteBookId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//隐藏添加笔记弹窗
					closeAddNoteWindow();
	    			
					//获取笔记的id
					var noteId=result.data.cn_note_id;
	    			
	    			//拼一个笔记字符串
					var s_li = "";
					s_li+='<li class="online">';
					s_li+='<a>';
					s_li+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
					s_li+= noteName;
					//s_li+='<i class="fa fa-sitemap"></i>';
					s_li+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					s_li+='</a>';
					s_li+='<div class="note_menu" tabindex="-1">';
					s_li+='<dl>';
					s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					s_li+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					s_li+='</dl>';
					s_li+='</div>';
					s_li+='</li>';
	    			//将笔记的id藏值
	    			var $s_li=$(s_li);//转换成jquery格式
	    			$s_li.data("noteId",noteId);//藏值
	    			//追加到笔记列表
	    			$("#note_list").append($s_li);
	    			
	    			
	    			}
			}, 
			error:function(){
				alert("创建失败");
			}
		});
	}
}


//编辑笔记
function showNote(){
	//给当前被选中的笔记li添加选中样式
	$("#note_list li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取笔记id
	var noteId=$(this).data("noteId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8081/SDAU_CloudNote/note/showNote.do",
		type:"post",
		dataType:"json",
		data:{"noteId":noteId},
		success:function(result){
			if(result.status==0){
				//将笔记标题放入编辑器标题中
				$("#input_note_title").val(result.data.cn_note_title);
				//将笔记的内容放入到编辑器文本框中
				um.setContent(result.data.cn_note_body);
			}
		}
	});
}

function saveNote(){
	//获取当前笔记的noteId
	var noteId=$("#note_list li a.checked").parent().data("noteId");
	//获取笔记标题noteTitle
	var noteTitle=$("#input_note_title").val();
	//获取笔记body
	var noteBody=um.getContent();
	
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8081/SDAU_CloudNote/note/savenote.do",
		type:"post",
		dataType:"json",
		data:{"noteId":noteId,"noteTitle":noteTitle,"body":noteBody},
		success:function(result){
			if(result.status==0){
				//标题有没有改
				var now_title=$("#note_list li a.checked").text().trim();
				if(now_title!=noteTitle){//现在获取的标题和笔记列表中的标题不一致
					var a='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+ noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					$("#note_list li a.checked").html(a);
				}
				
			}
		}
	});
	
	
}