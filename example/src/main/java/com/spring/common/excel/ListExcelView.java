package com.spring.common.excel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jxls.transformer.XLSTransformer;

public class ListExcelView extends AbstractView{
	static Logger logger = Logger.getLogger(ListExcelView.class);
	/*******************************************************************
	 * ���� : "Content-disposition : attachment �� ������ �ν� ����"
	 * 		Ȯ���ڸ� �����Ͽ� ���� Ȯ������ ���ϵ鿡 ����, �ٿ�ε�� ������ "���� �ٿ�ε�"��ȭ���ڸ�
	 * 		�����ֵ���  ����Ӽ��̶� �� �� �ִ�.
	 *******************************************************************/

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setHeader("Content-Disposition", "attachment;fileName=\""+model.get("file_name")+"_"+new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime())+".xlsx"+"\"");
		response.setContentType("application/x-msexcel; charset=UTF-8");
	
	
	/******************************************************
     * ���� : jXLS�� �������� ������ ���ø��� �̿��Ͽ�
     *       ���� ������ ��ȥ���� �����ϱ� ���� ��Ű��
     * (jXLS�� ���ø��� ������� ���� ���� ������ ����)
     ******************************************************/
	  String docRoot = request.getSession().getServletContext().getRealPath("/WEB-INF/excel/");
      logger.info("��� üũ(docRoot) : " + docRoot);
      InputStream is = new BufferedInputStream(new FileInputStream(docRoot + model.get("template")));
      
      XLSTransformer trans = new XLSTransformer();
      Workbook workbook = trans.transformXLS(is, model);
      is.close();
      
      workbook.write(response.getOutputStream());

}
}
