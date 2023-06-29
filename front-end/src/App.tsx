import { useEffect, useState } from 'react'
import { PlusCircleOutlined, EyeOutlined, MinusCircleOutlined, PlusOutlined, DeleteOutlined } from '@ant-design/icons';

import './App.css'
import { Button, Card, Col, Form, Input, Modal, Row, Space, Table, Tag } from 'antd'
import studentService from './services/StudentService';



function App() {
  const [loading, setLoading] = useState(false);
  const [list, setList] = useState<any[]>([]);
  const [major, setMajor] = useState<string>("");
  const [studentModalVisible, setStudentModalVisible] = useState(false);
  const [selectedItem, setSelectedItem] = useState<any>(null);
  const [form] = Form.useForm();

  const loadData = async (major: string) => {
    setLoading(true);
    const data = await studentService.getAll(major);
    setList(data as unknown as any[])
    setLoading(false)

  }

  useEffect(() => {
    loadData(major)
  }, [major])



  const columns = [
    {
      title: "Id",
      dataIndex: "id"
    },
    {
      title: "First Name",
      dataIndex: "firstName"
    }
    ,
    {
      title: "lastName",
      dataIndex: "lastName"
    }
    ,
    {
      title: "email",
      dataIndex: "email"
    },
    {
      title: "Major",
      dataIndex: "major",
      render: (major: string) => <Tag color={major.length % 2 === 0 ? "blue" : "cyan"}>{major}</Tag>
    },
    {
      title: "Number of Courses",
      dataIndex: "coursesTaken",
      render: (coursesTaken: any[]) => coursesTaken.length
    },
    {
      title: "",
      dataIndex: "id",
      render: (id: any, record: any) => <Space><Button shape='circle' danger onClick={() => {
        Modal.confirm({
          title: "would you like to delete this item permenantly?",
          onOk: async () => {
            await studentService.delete(id);
            await loadData("");
          }
        })
      }} icon={<DeleteOutlined />} />

        <Button icon={<EyeOutlined />}
          shape='circle'
          onClick={() => {
            form.setFieldsValue(record);
            setSelectedItem(record);
            setStudentModalVisible(true);
          }} />


      </Space>
    }

  ]


  return (
    <div className='p-12'>
      <Card title="Student management System">
        <Modal open={studentModalVisible} title="Student"
          onOk={async () => {
            try {
              const values = await form.validateFields();
              console.log(values);


              if (selectedItem !== null) {
                await studentService.update(selectedItem?.id, values);
              } else {
                await studentService.create(values);

              }
              form.resetFields();
              setStudentModalVisible(false);
              await loadData("");


            } catch (e) {

            }



          }}
          onCancel={() => {
            setStudentModalVisible(false);
            form.resetFields();
          }}>
          <Form form={form} layout="vertical">

            <Row gutter={[16, 16]}>
              <Col span={12}>
                <Form.Item label="First Name" rules={[{ required: true, message: 'first name is required' }]} name={"firstName"}>
                  <Input />
                </Form.Item>
              </Col>

              <Col span={12}>
                <Form.Item label="last Name" rules={[{ required: true, message: 'last name is required' }]} name={"lastName"}>
                  <Input />
                </Form.Item>
              </Col>


              <Col span={12}>
                <Form.Item label="email" rules={[{ required: true, message: 'email is required' }]} name={"email"}>
                  <Input type="email" />
                </Form.Item>
              </Col>

              <Col span={12}>
                <Form.Item label="Major" rules={[{ required: true, message: 'major is required' }]} name={"major"}>
                  <Input />
                </Form.Item>
              </Col>

              <Col span={24}>
                <Form.List name="coursesTaken">
                  {(fields, { add, remove }) => (
                    <>
                      {fields.map(({ key, name, ...restField }) => (
                        <Space key={key} style={{ display: 'flex', marginBottom: 8 }} align="baseline">
                          <Form.Item
                            {...restField}
                            name={[name, 'name']}
                            rules={[{ required: true, message: 'Missing Course name' }]}
                          >
                            <Input placeholder="Course Name" />
                          </Form.Item>
                          <Form.Item
                            {...restField}
                            name={[name, 'code']}
                            rules={[{ required: true, message: 'Missing course code' }]}
                          >
                            <Input placeholder="Course code" />
                          </Form.Item>
                          <MinusCircleOutlined onClick={() => remove(name)} />
                        </Space>
                      ))}
                      <Form.Item>
                        <Button type="dashed" onClick={() => add()} block icon={<PlusOutlined />}>
                          Add Course
                        </Button>
                      </Form.Item>
                    </>
                  )}
                </Form.List>
              </Col>
            </Row>
          </Form>

        </Modal>

        <Row justify={"space-between"}>
          <Col>
            <Input.Search onSearch={(s) => setMajor(s)} />
          </Col>

          <Col>
            <Button loading={loading} onClick={() => {

              setStudentModalVisible(true);
            }} icon={<PlusCircleOutlined />} >
              Add Student

            </Button>
          </Col>
        </Row>

      </Card>
      <Card>
        <Table loading={loading} columns={columns} dataSource={list} />
      </Card>

    </div>
  )
}

export default App
