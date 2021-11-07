package common.handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.service.AtchFileServiceImpl;
import common.service.IAtchFileService;
import common.vo.AtchFileVO;

public class FileDownloadHandler implements CommandHandler {

	private IAtchFileService fileService = AtchFileServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		long fileId = req.getParameter("fileId") != null ? 
				Long.parseLong(req.getParameter("fileId")) : -1;
		
		int fileSn = req.getParameter("fileSn") != null ?
				Integer.parseInt(req.getParameter("fileSn")) : 1;
		
		// �뙆�씪 �젙蹂� 議고쉶
		AtchFileVO atchFileVO = new AtchFileVO();
		atchFileVO.setAtchFileCd(fileId);
		atchFileVO.setFileSn(fileSn);
		atchFileVO = fileService.getAtchFileDetail(atchFileVO);
		
		// �뙆�씪 �떎�슫濡쒕뱶 泥섎━瑜� �쐞�븳 �쓳�떟�뿤�뜑 �젙蹂� �꽕�젙�븯湲�
		resp.setContentType("application/octet-stream");
		//�뼱�뼡 �뙆�씪�씠�뱺, �솗�옣�옄�뱺 �씪�떒 �떎�슫濡쒕뱶 諛쏆쓣 �닔 �엳�뒗 留덉엫 ���엯 : application/octet-stream
		
		//�뙆�씪紐낆씠 �븳湲��씪 寃쎌슦 源⑥쭏 �닔 �엳�쑝誘�濡� encoding泥섎━
		String fileName = URLEncoder.encode(atchFileVO.getFileOrignName(), "UTF-8");
		
		// +臾몄옄 怨듬갚�쑝濡� 諛붽퓭二쇨린
		//�뙆�씪紐낆뿉 怨듬갚臾몄옄( )瑜� �꽔�뿀�쓣 �떆, �떎�슫濡쒕뱶�븯硫� +臾몄옄濡� 蹂댁씠寃� �릺�뒗�뜲, 洹멸구 諛붽퓭二쇰뒗 �옉�뾽
		fileName.replaceAll("\\+", "%20"); //�띁�꽱�듃肄붾뱶媛믪쑝濡� 諛붽퓭二쇨린 �쐞�빐 %20, 紐⑤뱺 寃� �떎 �띁�꽱�듃 肄붾뵫�쑝濡� �릺�뼱�엳�뒗 �삎�깭(�썝�옒 �뿀�슜 臾몄옄�씤 �쁺�뼱,�닽�옄 �젣�쇅)
		resp.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		System.out.println("===================>" + atchFileVO.getFileStoreName());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(atchFileVO.getFilePath()));
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int c = 0;
		while((c = bis.read()) != -1) {
			bos.write(c);
		}
		
		bis.close();
		bos.close();
				
		return null;
		//酉고럹�씠吏�媛� �뾾�쑝硫� null諛섑솚, 酉고럹�씠吏�媛� �엳�쑝硫� 酉고럹�씠吏�(留곹겕) 諛섑솚
		//�븘源� html�뿉�꽌 遊ㅻ뜕 �궡�슜 媛숇떎, �쎒而⑦듃濡ㅻ윭�뿉�꽌 "// VIEW �솕硫� 泥섎━�븯湲�" �솗�씤�븯湲�
	}

}
