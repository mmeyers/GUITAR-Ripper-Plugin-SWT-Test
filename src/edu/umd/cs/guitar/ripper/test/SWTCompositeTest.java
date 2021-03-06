package edu.umd.cs.guitar.ripper.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umd.cs.guitar.model.GUITARConstants;
import edu.umd.cs.guitar.model.SWTWindow;
import edu.umd.cs.guitar.model.swtwidgets.SWTComposite;
import edu.umd.cs.guitar.model.swtwidgets.SWTWidgetFactory;


public class SWTCompositeTest {

	private Display display;
		
	@Before
	public void setUp() {
		if (display == null || display.isDisposed()) {
			display = new Display();
		}
	}
	
	@After
	public void tearDown() {
		display.dispose();
	}
	
	@Test
	public void testGetWidget() {
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
				
		SWTComposite comp = (SWTComposite) SWTWidgetFactory.INSTANCE.newSWTWidget(spinner, null);
		assertEquals(spinner, comp.getWidget());
	}
	
	@Test
	public void testGetTitle() {
		// TODO test once we implement this
	}
	
	@Test
	public void testGetX() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		assertEquals(0, factory.newSWTWidget(spinner, null).getX());
				
		spinner.setBounds(85, 110, 80, 30);
		assertEquals(85, factory.newSWTWidget(spinner, null).getX());
	}
	
	@Test
	public void testGetY() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		assertEquals(0, factory.newSWTWidget(spinner, null).getY());
				
		spinner.setBounds(85, 110, 80, 30);
		assertEquals(110, factory.newSWTWidget(spinner, null).getY());
	}
	
	@Test
	public void testGetGUIProperties() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
				
		factory.newSWTWidget(spinner, null).getGUIProperties();
		
		shell.setImage(new Image(display, 20, 20));
		factory.newSWTWidget(spinner, null).getGUIProperties();
		
		// TODO compare output instead of just making sure it doesn't error
	}
	
	@Test
	public void testGetClassVal() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		assertEquals(spinner.getClass().getName(), factory.newSWTWidget(spinner, null).getClassVal());
	}
	
	@Test
	public void testGetChildren() {
//		Shell shell = new Shell(display);
//		Menu menu = new Menu(shell, SWT.BAR);
//		shell.setMenuBar(menu);
//		
//		SWTComposite comp = factory.newSWTComposite(shell, null);
//		List<GComponent> children = comp.getChildren();
//		
//		menu.dispose();
//		Menu popUpMenu = new Menu(shell, SWT.POP_UP);
//		shell.setMenu(popUpMenu);
//		
//		Tray tray = display.getSystemTray();
//		new TrayItem(tray, SWT.NONE);
//		
//		children = comp.getChildren();
//		assertEquals(2, children.size());
		// TODO figure this out
	}
	
	@Test
	public void testGetParent() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		SWTComposite parent = (SWTComposite) factory.newSWTWidget(spinner, null).getParent();
		assertEquals(shell, parent.getWidget());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIsEnable() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		assertTrue(factory.newSWTWidget(spinner, null).isEnable());
		
		spinner.setEnabled(false);
		assertFalse(factory.newSWTWidget(spinner, null).isEnable());
		
		spinner.setEnabled(true);
		assertTrue(factory.newSWTWidget(spinner, null).isEnable());
		
		// make sure disabling parent disables child
		shell.setEnabled(false);
		assertFalse(factory.newSWTWidget(spinner, null).isEnable());
	}
	
	@Test
	public void testGetTypeVal() {
		SWTWidgetFactory factory = SWTWidgetFactory.INSTANCE;
		
		Shell shell = new Shell(display);
		SWTWindow window = new SWTWindow(shell);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		
		assertEquals(GUITARConstants.SYSTEM_INTERACTION, 
				factory.newSWTWidget(spinner, window).getTypeVal());
	}
	
	@Test
	public void testGetEventList() {
//		Shell shell = new Shell(display);
//		
////		GEvent event = mock(SWTEventHandler.class);
//		SWTComposite comp = new SWTComposite(shell, null);
//		
//		//when(event.isSupportedBy(any(GComponent.class))).thenReturn(true);
//
//		EventManager manager = EventManager.getInstance();	
//		
//		manager.registerEvent(MyEventNoConstructor.class);
//		comp.getEventList();
//		manager.getEvents().clear();
//		
//		manager.registerEvent(SWTEventHandlerStub.class);
//		comp.getEventList();
//		manager.getEvents().clear();
	}
}
