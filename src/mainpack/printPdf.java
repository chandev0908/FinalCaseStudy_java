package mainpack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class printPdf {
	public static void printThis(String pdfFileName, ArrayList<String> fName, ArrayList<String> studentID,
			ArrayList<String> email, ArrayList<String> permitCode, ArrayList<String> permitAvailability,
			ArrayList<String> course, ArrayList<String> phoneNum) {
		String path = "";
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.setSelectedFile(new File(".pdf"));
		int x = j.showSaveDialog(j);
		if (x == JFileChooser.APPROVE_OPTION) {
			path = j.getSelectedFile().getPath();
		}
		if(x == JFileChooser.CANCEL_OPTION){
			JOptionPane.showMessageDialog(null, "Canceled");
			return;
		}
		Document docsx = new Document(PageSize.A4);
		try {
			PdfWriter.getInstance(docsx, new FileOutputStream("" + path + "\\" + pdfFileName + ".pdf"));
			docsx.open();

			PdfPTable tbl = new PdfPTable(7);
			tbl.setTotalWidth(PageSize.A4.getWidth());
			tbl.setLockedWidth(true);

			tbl.addCell("Full Name");
			tbl.addCell("Course");
			tbl.addCell("Student ID");
			tbl.addCell("Permit Code");
			tbl.addCell("Permit Availability");
			tbl.addCell("Email");
			tbl.addCell("Phone #");

			for (int ij = 0; ij < fName.size(); ij++) {
				String fnames = fName.get(ij).toString();
				String studids = studentID.get(ij).toString();
				String emails = email.get(ij).toString();
				String pcodes = permitCode.get(ij).toString();
				String pavails = permitAvailability.get(ij).toString();
				String courses = course.get(ij).toString();
				String phones = phoneNum.get(ij).toString();

				tbl.addCell(fnames);
				tbl.addCell(courses);
				tbl.addCell(studids);
				tbl.addCell(pcodes);
				tbl.addCell(pavails);
				tbl.addCell(emails);
				tbl.addCell(phones);
			}
			docsx.add(tbl);
			docsx.close();
			JOptionPane.showMessageDialog(null, "PDF File Created", "Sucess!", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException dsa) {
			JOptionPane.showMessageDialog(null, "Error: "+ dsa);
		} catch (DocumentException asd) {
			JOptionPane.showMessageDialog(null, "Error: "+ asd);
		} catch (ExceptionConverter sda) {
			JOptionPane.showMessageDialog(null, "Error: "+ sda);
		}
	}
}
